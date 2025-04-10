package com.badiga.epa.Services;

import com.badiga.epa.DTOS.CartProductDto;
import com.badiga.epa.Exceptions.UserNotFoundException;
import com.badiga.epa.Models.Product;
import com.badiga.epa.Models.User;
import com.badiga.epa.Repositories.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("defaultCartService")
public class DefaultCartService implements CartServices{
    private UserRepository userRepository;


    @Override
    public ResponseEntity<Product> productIntoCart(Long userId, CartProductDto cartProductDto) throws UserNotFoundException {
        User user = userRepository.findById(userId);
        if(user != null) {
            user.getCart().setProductsQuantity(cartProductDto.getProducts());

        }
        throw new UserNotFoundException("Sorry user not found, please go and signup");

    }

    @Override
    public Map<Product, Integer> getCart(Long userId) throws UserNotFoundException {
        User user = userRepository.findById(userId);
        if(user != null) {
            return user.getCart().getProductsQuantity();
        }
        throw new UserNotFoundException("Sorry user not found, please go and signup");

    }
}
