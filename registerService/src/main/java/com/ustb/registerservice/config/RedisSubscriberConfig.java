//package com.ustb.registerservice.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.listener.PatternTopic;
//import org.springframework.data.redis.listener.RedisMessageListenerContainer;
//import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
//
///**
// * ClassName：RedisSubscriberConfig
// * Description:webSocket基于redis发布订阅，推送
// * author: mayouwen
// * date: 2020/8/28
// */
//public class RedisSubscriberConfig {
//
//    /**
//     * 消息监听适配器，注入接受消息方法
//     * @param receiver
//     * @return
//     */
//    public MessageListenerAdapter messageListenerAdapter(ChatMessageListener receiver) {
//        return new MessageListenerAdapter(receiver);
//    }
//
//    /**
//     * 创建消息监听容器
//     *
//     * @param redisConnectionFactory
//     * @param messageListenerAdapter2
//     * @return
//     */
//    @Bean
//    public RedisMessageListenerContainer getRedisMessageListenerContainer(RedisConnectionFactory redisConnectionFactory, MessageListenerAdapter messageListenerAdapter) {
//        RedisMessageListenerContainer redisMessageListenerContainer = new RedisMessageListenerContainer();
//        redisMessageListenerContainer.setConnectionFactory(redisConnectionFactory);
//        //订阅了一个叫chat的通道，可以添加多个MessageListener
//        redisMessageListenerContainer.addMessageListener(messageListenerAdapter, new PatternTopic("chat"));
//        return redisMessageListenerContainer;
//    }
//}
