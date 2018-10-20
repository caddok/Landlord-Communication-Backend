package com.evtimov.landlordapp.backend.repositories.base;

import com.evtimov.landlordapp.backend.models.Payment;

import java.util.List;

public interface PaymentRepository {

    Payment payYourBill(Payment payment);

    List<Payment> getAllPaymentsByUserId(int userId);
}
