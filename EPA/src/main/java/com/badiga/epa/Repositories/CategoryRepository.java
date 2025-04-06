package com.badiga.epa.Repositories;

import com.badiga.epa.Models.Category;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    public Category findByName(String name);
    public Category findById(int id);
    public Category save(Category category);
}
