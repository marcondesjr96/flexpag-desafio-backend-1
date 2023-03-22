package com.flexpag.paymentscheduler.service;

import com.flexpag.paymentscheduler.convert.PaymentConvert;
import com.flexpag.paymentscheduler.dto.PaymentDTO;
import com.flexpag.paymentscheduler.dto.PaymentFormDTO;
import com.flexpag.paymentscheduler.model.Payment;
import com.flexpag.paymentscheduler.model.enums.Status;
import com.flexpag.paymentscheduler.repository.PaymentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@AllArgsConstructor

public class PaymentServiceImp implements PaymentService {

    private final PaymentRepository paymentRepository;


    @Override
    public PaymentDTO getSchedule(Integer paymentId) throws Exception {
        Optional<Payment> paymentOpt = paymentRepository.findById(paymentId);

        if (!paymentOpt.isPresent()) {
            throw new Exception("Agendamento não encontrado");
        }

        return PaymentConvert.paymentModelToDTO(paymentOpt.get());
    }

    @Override
    public Integer addSchedule(PaymentFormDTO paymentForm) {
        Payment entity = PaymentConvert.paymentFormToPaymentEntity(paymentForm);
        paymentRepository.save(entity);

        return entity.getId();
    }

    @Override
    public PaymentDTO editSchedule (Integer paymentId, PaymentFormDTO paymentForm) throws Exception {
        Optional<Payment> paymentOpt = paymentRepository.findById(paymentId);
        if (!paymentOpt.isPresent()) {
            throw new Exception("Agendamento não encontrado");
        }
        if (paymentOpt.get().getPaymentStatus().equals(Status.PAID)) {
            throw new Exception("Agendamento pago, não pode editar!");
        }


        Payment entity = paymentOpt.get();
        entity.setDueDate(paymentForm.getDueDate());
        paymentRepository.save(entity);

        return PaymentConvert.paymentModelToDTO(entity);
    }

    @Override
    public void paySchedule(Integer paymentId) throws Exception {
        Optional<Payment> paymentOpt = paymentRepository.findById(paymentId);
        if (!paymentOpt.isPresent()) {
            throw new Exception("Agendamento não encontrado");
        }
        if (paymentOpt.get().getPaymentStatus().equals(Status.PAID)) {
            throw new Exception("O pagamento já foi efetuado para esse agendamento!");
        }

        Payment entity = paymentOpt.get();
        entity.setPaymentStatus(Status.PAID);
        paymentRepository.save(entity);
    }


    @Override
    public void deleteSchedule (Integer paymentId) throws Exception {
        Optional<Payment> paymentOpt = paymentRepository.findById(paymentId);
        if (!paymentOpt.isPresent()) {
            throw new Exception("Agendamento não encontrado");
        }
        if (paymentOpt.get().getPaymentStatus().equals(Status.PAID)) {
            throw new Exception("Agendamento pago, não pode deletar!");
        }
        paymentRepository.delete(paymentOpt.get());
    }

}
