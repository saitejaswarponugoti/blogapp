package com.saitejaswar.blogapp.mapper;

import com.saitejaswar.blogapp.domain.PostStatus;
import com.saitejaswar.blogapp.domain.entities.Category;
import com.saitejaswar.blogapp.dtos.CategoryDto;
import com.saitejaswar.blogapp.dtos.CreateCategoryRequest;
import com.saitejaswar.blogapp.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.UUID;

@RequiredArgsConstructor
public class CategoriesMapper {

    public static CategoryDto mapToCategoryDto(Category category, CategoryDto categoryDto) {
        categoryDto.setId(category.getId());
        categoryDto.setName(category.getName());
        categoryDto.setPostCount(category.getPosts().stream().filter(post -> PostStatus.PUBLISHED.equals(post.getStatus())).count());
        return categoryDto;
    }

    public static Category mapcreateCategoryRequestToCategory(CreateCategoryRequest createCategoryRequest, Category category) {
//        category.setId(UUID.randomUUID());
         category.setName(createCategoryRequest.getName());
         category.setPosts(new ArrayList<>());
         return category;
    }

}
