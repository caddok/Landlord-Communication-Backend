package com.evtimov.landlordapp.backend.controllers;


import com.evtimov.landlordapp.backend.models.Payment;
import com.evtimov.landlordapp.backend.services.base.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {


    private final PaymentService service;

    @Autowired
    public PaymentController(PaymentService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Payment payYourBill(@RequestBody @Valid Payment payment){
        service.payYourBill(payment);

        return payment;
    }

    @RequestMapping(value = "/tenant/{userId}", method = RequestMethod.GET)
    public List<Payment> getAllPaymentsByUserId(@PathVariable(value = "userId") int tenantId){
        return service.getAllPaymentsByUserId(tenantId);
    }

    @RequestMapping(value = "/landlord/{userId}", method = RequestMethod.GET)
    public List<Payment> getAllPaymentsByLandlordId(@PathVariable(value = "userId") int landlordId){
        return service.getAllPaymentsByLandlordId(landlordId);
    }
}
