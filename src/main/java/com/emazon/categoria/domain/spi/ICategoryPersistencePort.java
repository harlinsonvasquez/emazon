package com.emazon.categoria.domain.spi;

import com.emazon.categoria.domain.model.Category;

import java.util.List;

public interface ICategoryPersistencePort {
    Category saveCategory(Category category);
    Category getCategory(String name);
    List<Category> getAllCategories(Integer page, Integer size);
}
