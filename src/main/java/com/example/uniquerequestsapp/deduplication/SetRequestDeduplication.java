package com.example.uniquerequestsapp.deduplication;

import java.util.HashSet;
import java.util.Set;

public class SetRequestDeduplication implements RequestDeduplication{
    private Set<Integer> uniqueRequests = new HashSet<>();

    @Override
    public void add(int id) {
        uniqueRequests.add(id);
    }

    @Override
    public int getUniqueRequests() {
        return uniqueRequests.size();
    }

    @Override
    public void clear() {
        uniqueRequests.clear();
    }
}
