package com.saitejaswar.blogapp.controller;

import com.saitejaswar.blogapp.domain.entities.Category;
import com.saitejaswar.blogapp.dtos.CategoryDto;
import com.saitejaswar.blogapp.dtos.CreateCategoryRequest;
import com.saitejaswar.blogapp.mapper.CategoriesMapper;
import com.saitejaswar.blogapp.services.CategoryService;
import com.saitejaswar.blogapp.services.Impl.ICategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<CategoryDto>> listCategories() {
        List<CategoryDto> categories = categoryService.listCategories().stream()
                .map(category -> CategoriesMapper.mapToCategoryDto(category,new CategoryDto()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(categories);
    }

    @PostMapping
    public ResponseEntity<CategoryDto> createCategoryRequest(
            @Valid @RequestBody CreateCategoryRequest createCategoryRequest)
    {
        Category categoryToCreate = CategoriesMapper.mapcreateCategoryRequestToCategory(createCategoryRequest, new Category());
//        System.out.println(" Id mapped to create category request "+categoryToCreate.getId());
        Category savedCategory = categoryService.createCategory(categoryToCreate);
//        System.out.println(" Id saved category "+savedCategory.getId());
        return new ResponseEntity<>(
          CategoriesMapper.mapToCategoryDto(savedCategory, new CategoryDto()),
                HttpStatus.CREATED
        );
    }


}
