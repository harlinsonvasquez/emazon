package com.emazon.categoria.domain.api;

import com.emazon.categoria.domain.model.Category;

import java.util.List;

public interface ICategoryServicePort {
   Category saveCategory(Category category);
    Category getCategory(String name);
    List<Category> getAllCategories(Integer page, Integer size);
}
