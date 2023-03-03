package com.flexpag.paymentscheduler.repository;

import com.flexpag.paymentscheduler.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {

}
