package com.example.uniquerequestsapp.unique.requests.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogFileUniqueRequestProducer implements UniqueRequestProducer {
    private static final Logger logger = LoggerFactory.getLogger(LogFileUniqueRequestProducer.class);

    @Override
    public void produce(int uniqueRequests) {
        logger.info("Unique requests in last minute: {}", uniqueRequests);
    }
}
