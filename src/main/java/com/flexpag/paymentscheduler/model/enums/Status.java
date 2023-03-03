package com.flexpag.paymentscheduler.model.enums;

import lombok.Getter;

@Getter

public enum Status {
    PENDING("PENDING"),
    PAID("PAID");
    private String description;

    private Status(String description) {
        this.description = description;
    }
}
