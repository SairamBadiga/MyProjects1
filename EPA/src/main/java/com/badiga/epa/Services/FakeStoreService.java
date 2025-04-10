package com.badiga.epa.Services;

import com.badiga.epa.DTOS.ProductDto;
import com.badiga.epa.Exceptions.ProductNotFoundException;
import com.badiga.epa.Models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("FakeStoreService")
public class FakeStoreService implements ProductServices {

    public RestTemplate restTemplate;

    public FakeStoreService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;

    }
    @Override
    public List<Product> getProducts() {
        ProductDto[] products = restTemplate.getForObject("https://fakestoreapi.com/products", ProductDto[].class);
        List<Product> productList = new ArrayList<Product>();
        for(int i = 0; i<products.length; i++){
            //productList.add(products[i].toProduct());
        }
        return productList;

    }

    @Override
    public Product getProduct(int id) throws ProductNotFoundException {
        ProductDto product = restTemplate.getForObject("https://fakestoreapi.com/products/"+id, ProductDto.class);
        if(product ==null){
            throw new ProductNotFoundException("Product id is null");
        }
        System.out.println(product.getId());
        return null;
    }

    @Override
    public Product addProduct(ProductDto product) {
        ProductDto added_product = restTemplate.postForObject("https://fakestoreapi.com/products", product, ProductDto.class);
        System.out.println(added_product.getId());
        return null;

    }
}
