package com.saitejaswar.blogapp.services;

import com.saitejaswar.blogapp.domain.entities.Category;

import java.util.List;

public interface CategoryService {

    List<Category> listCategories();
    Category createCategory(Category category);

}
