package com.badiga.epa.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Entity
@Getter
@Setter
public class Cart extends BaseModel {
    @ElementCollection
    @MapKeyColumn(name = "product_id")
    @Column(name = "quantity")
    Map<Product, Integer> productsQuantity;

    public Map<Product, Integer> getProductsQuantity() {
        return productsQuantity;
    }

    public void setProductsQuantity(Map<Product, Integer> productsQuantity) {
        this.productsQuantity = productsQuantity;
    }
}
