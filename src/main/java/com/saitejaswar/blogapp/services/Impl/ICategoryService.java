package com.saitejaswar.blogapp.services.Impl;

import com.saitejaswar.blogapp.domain.entities.Category;
import com.saitejaswar.blogapp.repositories.CategoryRepository;
import com.saitejaswar.blogapp.services.CategoryService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ICategoryService implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> listCategories() {
        return categoryRepository.findAllWithPostCount();
    }

    @Override
    @Transactional
    public Category createCategory(Category category) {
        String categoryName = category.getName();
        if(categoryRepository.existsByNameIgnoreCase(categoryName)){
            throw new IllegalArgumentException("Category name already exists : " + categoryName);
        }else {
            return categoryRepository.save(category);
        }

    }

    @Override
    public void deleteCategory(UUID uuid) {
        Optional<Category> category = categoryRepository.findById(uuid);
        if(category.isPresent()){
            if (!category.get().getPosts().isEmpty()){
                throw new IllegalStateException("Category has posts associated with it");
            }
            categoryRepository.deleteById(uuid);
        }
    }
}
