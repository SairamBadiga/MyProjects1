package com.badiga.epa.Services;
import com.badiga.epa.Exceptions.CategoryAlreadyExistException;
import com.badiga.epa.Models.Category;
import com.badiga.epa.Repositories.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class DefaultCategoryService implements CategoryService {
    private CategoryRepository categoryRepository;
    public DefaultCategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;

    }
    @Override
    public void addCategory(String category) throws CategoryAlreadyExistException {
        if(categoryRepository.findByName(category) != null){
            throw new CategoryAlreadyExistException("Category already exists");

        }
        Category cat = new Category();
        cat.setName(category);
        categoryRepository.save(cat);

    }
}
