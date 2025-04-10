package com.badiga.epa.Adapters;

import com.badiga.epa.DTOS.PaymentOrderDto;
import com.badiga.epa.Services.PaymentServices;
import com.razorpay.PaymentLink;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;



@Component
public class RazorpayPaymentAdapter implements PaymentServices {
    private RazorpayClient razorpayClient;
    public RazorpayPaymentAdapter(RazorpayClient razorpayClient) {
        this.razorpayClient = razorpayClient;

    }
    @Override
    public PaymentLink initiatePayment(PaymentOrderDto paymentOrderDto) throws RazorpayException {
        //amount, user_id, order_id,user
        String referenceId = UUID.randomUUID().toString();
        JSONObject paymentLinkRequest = new JSONObject();
        paymentLinkRequest.put("amount",paymentOrderDto.getAmount());
        paymentLinkRequest.put("currency","INR");
        paymentLinkRequest.put("accept_partial",false);
        paymentLinkRequest.put("expire_by", LocalDateTime.now().plusMinutes(10));
        paymentLinkRequest.put("reference_id",referenceId);
        paymentLinkRequest.put("description","Payment for policy no #23456");
        JSONObject customer = new JSONObject();
        customer.put("name", paymentOrderDto.getUserName());
        customer.put("contact", paymentOrderDto.getPhoneNumber());
        customer.put("email", paymentOrderDto.getEmail());
        paymentLinkRequest.put("customer",customer);
        JSONObject notify = new JSONObject();
        notify.put("sms",true);
        notify.put("email",true);
        paymentLinkRequest.put("reminder_enable",true);
        JSONObject notes = new JSONObject();
        paymentLinkRequest.put("callback_url","https://www.google.com");
        paymentLinkRequest.put("callback_method","get");

        PaymentLink payment = razorpayClient.paymentLink.create(paymentLinkRequest);
        return payment;
    }
}
