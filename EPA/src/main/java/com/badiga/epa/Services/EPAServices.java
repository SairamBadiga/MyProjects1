package com.badiga.epa.Services;

import com.badiga.epa.DTOS.FakeStoreProductDto;
import com.badiga.epa.Exceptions.ProductNotFoundException;
import com.badiga.epa.Models.Product;
import org.springframework.stereotype.Service;

import java.util.List;


public interface EPAServices {
    public List<Product> getProducts();
    public Product getProduct(int id) throws ProductNotFoundException;
    public Product addProduct(Product product);

}
