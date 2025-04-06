package com.badiga.epa.Services;

import com.badiga.epa.DTOS.FakeStoreProductDto;
import com.badiga.epa.Exceptions.ProductNotFoundException;
import com.badiga.epa.Models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("FakeStoreService")
public class FakeStoreService implements EPAServices{

    public RestTemplate restTemplate;

    public FakeStoreService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;

    }
    @Override
    public List<Product> getProducts() {
        FakeStoreProductDto[] products = restTemplate.getForObject("https://fakestoreapi.com/products", FakeStoreProductDto[].class);
        List<Product> productList = new ArrayList<Product>();
        for(int i = 0; i<products.length; i++){
            productList.add(products[i].toProduct());
        }
        return productList;

    }

    @Override
    public Product getProduct(int id) throws ProductNotFoundException {
        FakeStoreProductDto product = restTemplate.getForObject("https://fakestoreapi.com/products/"+id, FakeStoreProductDto.class);
        if(product ==null){
            throw new ProductNotFoundException("Product id is null");
        }
        System.out.println(product.getId());
        return product.toProduct();
    }

    @Override
    public Product addProduct(Product product) {
        FakeStoreProductDto added_product = restTemplate.postForObject("https://fakestoreapi.com/products", product, FakeStoreProductDto.class);
        System.out.println(added_product.getId());
        return added_product.toProduct();

    }
}
