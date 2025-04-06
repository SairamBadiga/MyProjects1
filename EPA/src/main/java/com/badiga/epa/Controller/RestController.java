package com.badiga.epa.Controller;

import com.badiga.epa.DTOS.FakeStoreProductDto;
import com.badiga.epa.Exceptions.ProductNotFoundException;
import com.badiga.epa.Models.Product;
import com.badiga.epa.Services.EPAServices;
import com.badiga.epa.Services.EPAStoreService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    public EPAServices epaServices;
    public RestController(@Qualifier("EPAStoreService") EPAServices epaServices) {
        this.epaServices = epaServices;

    }

    @GetMapping("/product/{id}")
    public Product getProduct(@PathVariable int id) throws ProductNotFoundException {

        return epaServices.getProduct(id);
    }

    @GetMapping("/products")
    public List<Product> getProducts() {
        return epaServices.getProducts();


    }

    @PostMapping("/products")
    public Product addProduct(@RequestBody FakeStoreProductDto product) {

        return epaServices.addProduct(product.toProduct());

    }

    @ExceptionHandler(ProductNotFoundException.class)
    public String pnfex(ProductNotFoundException e) {
        return e.getMessage();
    }


}
