package com.ustb.registerservice.config;


import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;

/**
 * ClassName：ChatMessageListener
 * Description:
 * author: mayouwen
 * date: 2020/8/28
 */
public class ChatMessageListener implements MessageListener {
    @Override
    public void onMessage(Message message, byte[] bytes) {

    }
}
