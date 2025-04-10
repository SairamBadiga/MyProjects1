package com.badiga.epa.Repositories;

import com.badiga.epa.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    public Product findById(int id);
    public Product findByName(String name);
    public Product save(Product product);



}
