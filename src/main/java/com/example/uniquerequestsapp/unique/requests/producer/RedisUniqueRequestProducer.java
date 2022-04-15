package com.example.uniquerequestsapp.unique.requests.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;

public class RedisUniqueRequestProducer implements UniqueRequestProducer {

    @Autowired
    private RedisTemplate<String, String> template;

    @Value("${config.redis.channel}")
    private String channel;

    @Override
    public void produce(int requests) {
        template.convertAndSend(channel, String.valueOf(requests));
    }
}
