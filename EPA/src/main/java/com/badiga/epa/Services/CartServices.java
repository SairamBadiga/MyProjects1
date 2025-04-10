package com.badiga.epa.Services;

import com.badiga.epa.DTOS.CartProductDto;
import com.badiga.epa.Exceptions.UserNotFoundException;
import com.badiga.epa.Models.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface CartServices {
    public ResponseEntity<Product> productIntoCart(Long userId, CartProductDto cartProductDtoList) throws UserNotFoundException;
    public Map<Product, Integer> getCart(Long userId) throws UserNotFoundException;
}
