package com.carservice.exceptions;

public class ServiceJobNotFoundException extends RuntimeException {
    public ServiceJobNotFoundException(String message) {
        super(message);
    }
}
