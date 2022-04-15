package com.example.uniquerequestsapp.unique.requests.producer;


import com.example.uniquerequestsapp.deduplication.RequestDeduplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class UniqueRequestsScheduler {

    @Autowired
    private RequestDeduplication uniqueRequests;

    @Autowired
    private UniqueRequestProducer uniqueRequestProducer;

    @Scheduled(fixedRate = 60 * 1000)
    private void logToFileUniqueRequestsInLastMinute() {
        uniqueRequestProducer.produce(uniqueRequests.getUniqueRequests());
        uniqueRequests.clear();
    }
}
