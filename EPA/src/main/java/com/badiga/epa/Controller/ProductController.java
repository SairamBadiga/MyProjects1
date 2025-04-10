package com.badiga.epa.Controller;

import com.badiga.epa.DTOS.ProductDto;
import com.badiga.epa.Exceptions.ProductNotFoundException;
import com.badiga.epa.Models.Product;
import com.badiga.epa.Services.ProductServices;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class ProductController {
    public ProductServices productServices;
    public ProductController(@Qualifier("defaultProductService") ProductServices productServices) {
        this.productServices = productServices;

    }

    @GetMapping("/product/{id}")
    public Product getProduct(@PathVariable int id) throws ProductNotFoundException {

        return productServices.getProduct(id);
    }

    @GetMapping("/producs")
    public List<Product> getProducts() {
        return productServices.getProducts();


    }

    @PostMapping("/products")
    public Product addProduct(@RequestBody ProductDto product) {

        return productServices.addProduct(product);

    }

}
