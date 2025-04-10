package com.badiga.epa.Services;

import com.badiga.epa.DTOS.ProductDto;
import com.badiga.epa.Exceptions.ProductNotFoundException;
import com.badiga.epa.Models.Product;

import java.util.List;


public interface ProductServices {
    public List<Product> getProducts();
    public Product getProduct(int id) throws ProductNotFoundException;
    public Product addProduct(ProductDto product);

}
