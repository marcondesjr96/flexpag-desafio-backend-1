package com.flexpag.paymentscheduler.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.flexpag.paymentscheduler.model.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class PaymentFormDTO implements Serializable {

    private double money;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss", timezone = "GMT")
    private LocalDateTime dueDate;
    private Status paymentStatus;
}
