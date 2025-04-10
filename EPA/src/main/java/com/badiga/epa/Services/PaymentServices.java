package com.badiga.epa.Services;

import com.badiga.epa.DTOS.PaymentOrderDto;
import com.razorpay.PaymentLink;
import com.razorpay.RazorpayException;

public interface PaymentServices {
    public PaymentLink initiatePayment(PaymentOrderDto paymentOrderDto) throws RazorpayException;
}
