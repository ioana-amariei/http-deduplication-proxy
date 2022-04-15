package com.example.uniquerequestsapp.deduplication;

public interface RequestDeduplication {

    void add(int id);

    int getUniqueRequests();

    void clear();
}
