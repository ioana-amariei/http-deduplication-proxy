package com.example.uniquerequestsapp.deduplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;

public class RedisRequestDeduplication implements RequestDeduplication {

    @Autowired
    private RedisTemplate<String, Integer> template;

    @Value("${config.redis.set}")
    private String setName;

    @Override
    public void add(int id) {
        template.opsForSet().add(setName, id);
    }

    @Override
    public int getUniqueRequests() {
        return template.opsForSet().size(setName).intValue();
    }

    @Override
    public void clear() {
        template.opsForSet().pop(setName, getUniqueRequests());
    }
}
