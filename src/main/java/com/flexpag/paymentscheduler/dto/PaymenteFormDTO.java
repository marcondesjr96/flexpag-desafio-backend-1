package com.flexpag.paymentscheduler.dto;

import com.flexpag.paymentscheduler.model.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class PaymenteFormDTO implements Serializable {

    private double money;
    private Date dueDate;
    private Status paymentStatus;
}
