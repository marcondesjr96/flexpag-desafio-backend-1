package com.flexpag.paymentscheduler.dto;

import com.flexpag.paymentscheduler.model.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class PaymentDTO implements Serializable {


    private Integer id;
    private Status paymentStatus;
    private Date dueDate;



}
