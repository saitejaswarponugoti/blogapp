package com.saitejaswar.blogapp.services;

import com.saitejaswar.blogapp.domain.entities.Category;

import java.util.List;
import java.util.UUID;

public interface CategoryService {

    List<Category> listCategories();
    Category createCategory(Category category);
    void deleteCategory(UUID uuid);

}
