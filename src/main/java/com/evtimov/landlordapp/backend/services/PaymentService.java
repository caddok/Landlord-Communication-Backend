package com.evtimov.landlordapp.backend.services;

import com.evtimov.landlordapp.backend.models.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentService {
    private final PaymentRepository repository;

    @Autowired
    public PaymentService(PaymentRepository repository) {
        this.repository = repository;
    }

    public void payYourBill(Payment payment) {
        repository.save(payment);
    }

    public List<Payment> getAllPaymentsByUserId(int id){
        List<Payment> allPayments = (List<Payment>) repository.findAll();
        return allPayments.stream()
                .filter(payment -> payment.getUser().getUserID()==id)
                .collect(Collectors.toList());
    }



}
