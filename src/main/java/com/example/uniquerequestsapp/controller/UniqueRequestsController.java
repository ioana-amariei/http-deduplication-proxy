package com.example.uniquerequestsapp.controller;

import com.example.uniquerequestsapp.service.UniqueRequestsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UniqueRequestsController {
    private static final Logger logger = LoggerFactory.getLogger(UniqueRequestsController.class);

    @Autowired
    private UniqueRequestsService uniqueRequestsService;

    @GetMapping("/accept")
    public String accept(@RequestParam(value = "id") Integer id, @RequestParam(value = "endpoint", required = false) String endpoint) {
        return uniqueRequestsService.accept(id, endpoint);
    }

    @ExceptionHandler
    public String handleException(Exception e) {
        logger.error(e.getMessage());
        return "failed";
    }

}
