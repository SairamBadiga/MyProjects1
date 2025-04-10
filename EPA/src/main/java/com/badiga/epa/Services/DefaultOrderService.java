package com.badiga.epa.Services;

import com.badiga.epa.DTOS.CartProductDto;
import com.badiga.epa.Models.Cart;
import com.badiga.epa.Models.Order;
import com.badiga.epa.Models.Product;
import com.badiga.epa.Models.User;
import com.badiga.epa.Repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DefaultOrderService implements OrderService {
    private UserRepository userRepository;
    public DefaultOrderService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public double totalAmount(Cart cart) {
        double totalAmount = 0;
        for(Map.Entry<Product, Integer> each : cart.getProductsQuantity().entrySet()) {
            totalAmount = totalAmount + (each.getValue() * each.getKey().getPrice());

        }
        return totalAmount;
    }
    @Override
    public double buyAllProducts(Long userId) {
        User user = userRepository.findById(userId);
        double totalPrice = totalAmount(user.getCart());
        return totalPrice;

    }

    @Override
    public void buySelectedProducts(Long userId, CartProductDto cartProductDto) {

    }

    @Override
    public void makePayment() {

    }

    @Override
    public Order getOrderById(Long orderId) {
        return null;
    }
}
