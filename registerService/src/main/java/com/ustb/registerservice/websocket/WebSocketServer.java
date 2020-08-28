package com.ustb.registerservice.websocket;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * ClassName：WebSocketServer
 * Description:
 * author: mayouwen
 * date: 2020/8/28
 */
@Component
@ServerEndpoint(value = "/websocket/{userId}")
@Slf4j
public class WebSocketServer {

    /**
     * 在线人数
     */
    private static int onlineNumber = 0;

    private static Map<String, WebSocketServer> clients = new ConcurrentHashMap<>();

    private Session session;

    private String userId;

    /**
     * 建立连接
     * @param userId
     * @param session
     */
    @OnOpen
    public void onOpen(@PathParam("userId") String userId, Session session) {
        this.session = session;
        this.userId = userId;
        clients.put(userId, this);
        addOnlineCount();
        log.info("有新窗口监听：" + userId + ",当前在线人数为：" + getOnlineCount());

    }

    @OnMessage
    public void onMessage(Session session, String message) {
        log.info("收到客户端：" + userId + "消息：" + message);
        //群发消息
        for (WebSocketServer wb : clients.values()) {
            try {
                wb.sendMessage(message);
            } catch (Exception e) {
                log.error("消息发送失败【{}】", e);
            }
        }
    }

    @OnError
    public void onError(Session session, Throwable error) {
        log.error("服务端发生错误【{}】", error);
    }

    @OnClose
    public void onClose() {
        subOnlineCount();
        clients.remove(userId);
        log.info("有连接关闭【{}】", userId);
        log.info("当前在线人数为" + getOnlineCount());
    }

    public  void sendMessage(String message) throws Exception {
        this.session.getBasicRemote().sendText(message);
    }

    public static void sendMessage(String message, @PathParam("userId") String userId) {
        log.info("推送消息到窗口：" + userId + ", 推送内容：" + message);

        for (WebSocketServer wb : clients.values()) {
            if (wb.userId.equals(userId)) {
                try {
                    wb.sendMessage(message);
                } catch (Exception e) {
                    continue;
                }
                break;
            }
        }
    }

    public static synchronized int getOnlineCount() {
        return WebSocketServer.onlineNumber;
    }

    public static synchronized void addOnlineCount() {
        WebSocketServer.onlineNumber ++;
    }

    public static synchronized void subOnlineCount() {
        WebSocketServer.onlineNumber --;
    }
}
