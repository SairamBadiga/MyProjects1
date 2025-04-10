package com.badiga.epa.DTOS;

import com.badiga.epa.Models.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class CartProductDto {
    private Map<Product,Integer> products;

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public void setProducts(Map<Product, Integer> products) {
        this.products = products;
    }
}
