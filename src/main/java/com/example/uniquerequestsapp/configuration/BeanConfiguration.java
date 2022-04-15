package com.example.uniquerequestsapp.configuration;

import com.example.uniquerequestsapp.deduplication.RedisRequestDeduplication;
import com.example.uniquerequestsapp.deduplication.RequestDeduplication;
import com.example.uniquerequestsapp.unique.requests.producer.RedisUniqueRequestProducer;
import com.example.uniquerequestsapp.unique.requests.producer.UniqueRequestProducer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class BeanConfiguration {

    @Bean
    public RequestDeduplication uniqueRequests() {
        return new RedisRequestDeduplication();
    }

    @Bean
    public UniqueRequestProducer uniqueRequestProducer() {
        return new RedisUniqueRequestProducer();
    }

    @Bean
    public RedisTemplate<?, ?> redisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<?, ?> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);

        return template;
    }
}
