package com.carservice.data.enums;

import lombok.Getter;

@Getter
public enum ServiceJobStatus {
    NEW("New"),
    IN_PROGRESS("In progress"),
    DONE("Done");

    private final String serviceJobStatus;

    ServiceJobStatus(String serviceJobStatus) {
        this.serviceJobStatus = serviceJobStatus;
    }

}
