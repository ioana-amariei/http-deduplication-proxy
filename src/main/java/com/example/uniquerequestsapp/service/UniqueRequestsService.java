package com.example.uniquerequestsapp.service;

import com.example.uniquerequestsapp.deduplication.RequestDeduplication;
import com.example.uniquerequestsapp.model.UniqueRequests;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UniqueRequestsService {
    private static final Logger logger = LoggerFactory.getLogger(UniqueRequestsService.class);

    @Autowired
    private RequestDeduplication uniqueRequests;

    private RestTemplate restTemplate = new RestTemplate();

    public String accept(Integer id, String endpoint) {
        uniqueRequests.add(id);

        if (endpoint == null || endpoint.isEmpty()) {
            return "ok";
        } else {
            UniqueRequests count = new UniqueRequests(uniqueRequests.getUniqueRequests());
            ResponseEntity<String> response = restTemplate.postForEntity(endpoint, count, String.class);

            logger.info("HTTP Status Code of the response: {}", response.getStatusCode());

            return response.getStatusCode().is2xxSuccessful() ? "ok" : "failed";
        }
    }

}
