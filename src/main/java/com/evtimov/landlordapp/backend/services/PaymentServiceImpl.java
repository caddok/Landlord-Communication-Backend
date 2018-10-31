package com.evtimov.landlordapp.backend.services;

import com.evtimov.landlordapp.backend.models.Payment;
import com.evtimov.landlordapp.backend.repositories.base.PaymentRepository;
import com.evtimov.landlordapp.backend.services.base.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository repository;

    @Autowired
    public PaymentServiceImpl(PaymentRepository repository) {
        this.repository = repository;
    }

    @Override
    public Payment payYourBill(Payment payment) {
        repository.payYourBill(payment);

        return payment;
    }

    @Override
    public List<Payment> getAllPaymentsByUserId(int userId){
        return repository.getAllPaymentsByUserId(userId);
    }

    @Override
    public List<Payment> getAllPaymentsByLandlordId(int landlordId) {
        List<Payment> allPayments = repository.getAllPayments();
        List<Payment> landlordIncomingPayments = allPayments
                .stream()
                .filter(payment -> payment.getPlace().getLandlordID() == landlordId)
                .collect(Collectors.toList());
        return landlordIncomingPayments;
    }
}
