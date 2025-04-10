package com.badiga.epa.Services;

import com.badiga.epa.Exceptions.CategoryAlreadyExistException;
import com.badiga.epa.Models.Category;

public interface CategoryService {

    public void addCategory(String category) throws CategoryAlreadyExistException;
}
