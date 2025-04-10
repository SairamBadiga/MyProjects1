package com.badiga.epa.Controller;

import com.badiga.epa.DTOS.PaymentOrderDto;
import com.badiga.epa.Exceptions.UserNotFoundException;
import com.badiga.epa.Models.Order;
import com.badiga.epa.Models.Payment;
import com.badiga.epa.Models.User;
import com.badiga.epa.Services.OrderService;
import com.badiga.epa.Services.PaymentServices;
import com.badiga.epa.Services.UserServices;
import com.razorpay.PaymentLink;
import com.razorpay.RazorpayException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {
    private PaymentServices paymentServices;
    private UserServices userServices;
    private OrderService orderService;
    public PaymentController(PaymentServices paymentServices, UserServices userServices, OrderService orderService) {
        this.paymentServices = paymentServices;
        this.userServices = userServices;
        this.orderService = orderService;
    }


    @PostMapping("{user_id}/{order_id}/payments")
    public void payment(@PathVariable Long order_id,@PathVariable Long user_id) throws UserNotFoundException, RazorpayException {
        User user = userServices.getUser(user_id);
        Order order = orderService.getOrderById(order_id);
        PaymentOrderDto paymentOrderDto = new PaymentOrderDto();
        paymentOrderDto.setOrderId(order_id);
        paymentOrderDto.setAddress(user.getAddress());
        paymentOrderDto.setEmail(user.getEmail());
        paymentOrderDto.setAmount(order.getPrice());
        paymentOrderDto.setPassword(user.getPassword());
        PaymentLink paymentLink =  paymentServices.initiatePayment(paymentOrderDto);

    }
}
