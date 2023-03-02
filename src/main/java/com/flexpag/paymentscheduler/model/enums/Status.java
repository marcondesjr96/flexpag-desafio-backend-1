package com.flexpag.paymentscheduler.model.enums;

import lombok.Getter;

@Getter

public enum Status {
    PENDING(1,"PENDING"),
    PAID(2, "PAID");
    private int cod;
    private String description;

    private Status(int cod, String description) {
        this.cod = cod;
        this.description = description;
    }
}
