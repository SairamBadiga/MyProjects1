package com.badiga.epa.Services;


import com.badiga.epa.DTOS.CartProductDto;
import com.badiga.epa.Models.Order;

public interface OrderService {
    public double buyAllProducts(Long userId);
    public void buySelectedProducts(Long userId, CartProductDto cartProductDto);
    public void makePayment();
    public Order getOrderById(Long orderId);
}
