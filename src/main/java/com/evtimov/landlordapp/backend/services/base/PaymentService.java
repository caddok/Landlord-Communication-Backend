package com.evtimov.landlordapp.backend.services.base;

import com.evtimov.landlordapp.backend.models.Payment;

import java.util.List;

public interface PaymentService {

    Payment payYourBill(Payment payment);

    List<Payment> getAllPaymentsByTenantId(int tenantId);

    List<Payment> getAllPaymentsByLandlordId(int landlordId);
}
