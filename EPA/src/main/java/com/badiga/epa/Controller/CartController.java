package com.badiga.epa.Controller;

import com.badiga.epa.DTOS.CartProductDto;
import com.badiga.epa.Exceptions.UserNotFoundException;
import com.badiga.epa.Models.Product;
import com.badiga.epa.Services.CartServices;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class CartController {
    private CartServices cartServices;
    public CartController(@Qualifier("defaultCartService")CartServices cartServices) {
        this.cartServices = cartServices;
    }
    @PostMapping("{userId}/cart")
    public ResponseEntity<Product> addProductIntoCart(@PathVariable Long userId, @RequestBody CartProductDto  cartProductDto) throws UserNotFoundException {
        ResponseEntity<Product> product = cartServices.productIntoCart(userId, cartProductDto);
        return product;
    }
    @GetMapping("/{userId}/cartProducts")
    public CartProductDto getCartProducts(@PathVariable Long userId) throws UserNotFoundException {
        Map<Product, Integer> cartProducts = cartServices.getCart(userId);
        return null;

    }

}
