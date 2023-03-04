package com.flexpag.paymentscheduler.service;

import com.flexpag.paymentscheduler.dto.PaymentDTO;
import com.flexpag.paymentscheduler.dto.PaymentFormDTO;
import com.flexpag.paymentscheduler.model.Payment;

public interface PaymentService {

    public PaymentDTO getSchedule (Integer paymentId) throws Exception;
    public Integer addSchedule(PaymentFormDTO payment) throws Exception;
    public PaymentDTO editSchedule(Integer paymentId, PaymentFormDTO paymentForm) throws Exception;
    public void paySchedule (Integer paymentId) throws Exception;
    public void deleteSchedule (Integer paymentId) throws Exception;



}
