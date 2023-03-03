package com.flexpag.paymentscheduler.resource;

import com.flexpag.paymentscheduler.dto.PaymentDTO;
import com.flexpag.paymentscheduler.dto.PaymentFormDTO;
import com.flexpag.paymentscheduler.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/schedule")
@RequiredArgsConstructor

public class PaymentResource {

    private final PaymentService paymentService;

    @GetMapping("/{id}")
    public ResponseEntity<PaymentDTO> findSchedule(@PathVariable("id") Integer id) throws Exception {
        return ResponseEntity.ok(paymentService.getSchedule(id));
    }

    @PostMapping
    public ResponseEntity<Integer> addSchedule(@RequestBody PaymentFormDTO paymentForm) throws Exception {
        return ResponseEntity.ok(paymentService.addSchedule(paymentForm));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PaymentDTO> editSchedule(@PathVariable("id") Integer id, @RequestBody PaymentFormDTO paymentForm) throws Exception {
        PaymentDTO payment = paymentService.editSchedule(id, paymentForm);
        return ResponseEntity.status(HttpStatus.OK).body(payment);
    }

    @PutMapping("/pay/{id}")
    public ResponseEntity<String> paySchedule(@PathVariable("id") Integer id) throws Exception {
        paymentService.paySchedule(id);
        return ResponseEntity.status(HttpStatus.OK).body("Pagamento efetuado com sucesso!");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSchedule(@PathVariable("id") Integer id) throws Exception {
        paymentService.deleteSchedule(id);
        return ResponseEntity.status(HttpStatus.OK).body("Agendamento deletado com sucesso!");
    }


}
