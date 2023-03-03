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
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class PaymentDTO implements Serializable {


    private Integer id;
    private Status paymentStatus;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT")
    private LocalDateTime dueDate;



}
