package com.evtimov.landlordapp.backend;

import com.evtimov.landlordapp.backend.models.Payment;
import com.evtimov.landlordapp.backend.repositories.base.PaymentRepository;
import com.evtimov.landlordapp.backend.services.PaymentServiceImpl;
import com.evtimov.landlordapp.backend.services.base.PaymentService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;

@RunWith(MockitoJUnitRunner.class)
public class PaymentServiceTests {
    @Mock
    PaymentRepository mockRepository;

    @Mock
    PaymentService paymentService;

    @InjectMocks
    PaymentServiceImpl mockService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void verifyRepositoryExecutes_payYourBill_whenCalled() {
        Payment payment = mock(Payment.class);
        paymentService.payYourBill(payment);
        Mockito.verify(paymentService,times(1))
                .payYourBill(payment);
    }

    @Test
    public void verifyRepositoryExecutes_getAllPaymentsBy_whenCalled(){
        mockRepository.getAllPayments();
        Mockito.verify(mockRepository,times(1))
                .getAllPayments();
    }

    @Test
    public void getAllPaymentsByTenantId_shouldReturnPayments_forSpecificUserId(){
        List<Payment> testList = new ArrayList<>();
        testList.add(new Payment(100,"10/10/2010",1,1,1,1));
        testList.add(new Payment(100,"10/10/2010",1,1,1,1));
        testList.add(new Payment(100,"10/10/2010",1,1,1,1));
        testList.add(new Payment(100,"10/10/2010",1,1,1,1));
        Mockito.when(mockService.getAllPaymentsByTenantId(1))
                .thenReturn(testList);
        List<Payment> result = mockService.getAllPaymentsByTenantId(1);
        Assert.assertEquals(4,result.size());
    }

    @Test
    public void getAllPaymentsByLandlordId_shouldReturnPayments_forSpecificId() {
        List<Payment> testList = new ArrayList<>();
        testList.add(new Payment(100,"10/10/2010",1,1,1,1));
        testList.add(new Payment(100,"10/10/2010",1,1,1,1));
        testList.add(new Payment(100,"10/10/2010",1,1,1,1));

        Mockito.when(mockService.getAllPaymentsByTenantId(1))
                .thenReturn(testList);

        List<Payment> result = mockService.getAllPaymentsByTenantId(1);
        Assert.assertEquals(3,result.size());
    }
}
