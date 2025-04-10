package com.badiga.epa.Services;

import com.badiga.epa.DTOS.ProductDto;
import com.badiga.epa.Exceptions.ProductNotFoundException;
import com.badiga.epa.Models.Category;
import com.badiga.epa.Models.Product;
import com.badiga.epa.Repositories.CategoryRepository;
import com.badiga.epa.Repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("defaultProductService")
public class DefaultProductService implements ProductServices {
    ProductRepository productRepository;
    CategoryRepository categoryRepository;
    public DefaultProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;

    }

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProduct(int id) throws ProductNotFoundException {
        Product p =  productRepository.findById(id);
        if(p==null){
            throw new ProductNotFoundException("Product not found");
        }
        return p;
    }

    @Override
    public Product addProduct(ProductDto product) {
        String cat = product.getCategory();
        Category category;
        if(categoryRepository.findByName(cat) == null){
            category = new Category();
            category.setName(cat);
            categoryRepository.save(category);
        }
        category = categoryRepository.findByName(cat);
        if(productRepository.findByName(product.getTitle()) == null){
            Product p = new Product();
            p.setName(product.getTitle());
            p.setColor(product.getColor());
            p.setPrice(product.getPrice());
            p.setSize(product.getSize());
            p.setImageURL(product.getImageUrl());
            p.setDescription(product.getDescription());
            p.setCategory(category);
        }
        return productRepository.findByName(product.getTitle());

    }
}
