package com.badiga.epa.Services;

import com.badiga.epa.Exceptions.ProductNotFoundException;
import com.badiga.epa.Models.Category;
import com.badiga.epa.Models.Product;
import com.badiga.epa.Repositories.CategoryRepository;
import com.badiga.epa.Repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("EPAStoreService")
public class EPAStoreService implements  EPAServices{
    ProductRepository productRepository;
    CategoryRepository categoryRepository;
    public EPAStoreService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;

    }
//    public EPAStroreService(CategoryRepository categoryRepository) {
//        this.categoryRepository = categoryRepository;
//
//    }

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
    public Product addProduct(Product product) {
        Category category = product.getCategory();
        String categoryName = category.getName();
        if(categoryRepository.findByName(categoryName) == null){
            categoryRepository.save(category);
        }
        return productRepository.save(product);

    }
}
