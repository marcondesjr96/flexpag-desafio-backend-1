package com.flexpag.paymentscheduler.convert;

import com.flexpag.paymentscheduler.dto.PaymentDTO;
import com.flexpag.paymentscheduler.dto.PaymentFormDTO;
import com.flexpag.paymentscheduler.model.Payment;
import com.flexpag.paymentscheduler.model.enums.Status;

public class PaymentConvert {


    public static PaymentDTO paymentModelToDTO( Payment payment) {
        return PaymentDTO.builder()
                .id(payment.getId())
                .paymentStatus(payment.getPaymentStatus())
                .dueDate(payment.getDueDate())
                .build();
    }

    public static Payment paymentFormToPaymentEntity(PaymentFormDTO paymentForm) {
        return Payment.builder()
                .money(paymentForm.getMoney())
                .dueDate(paymentForm.getDueDate())
                .paymentStatus(Status.PENDING)
                .build();
    }


}
