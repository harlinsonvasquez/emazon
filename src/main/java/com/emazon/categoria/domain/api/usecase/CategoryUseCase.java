package com.emazon.categoria.domain.api.usecase;

import com.emazon.categoria.domain.api.ICategoryServicePort;
import com.emazon.categoria.domain.model.Category;
import com.emazon.categoria.domain.spi.ICategoryPersistencePort;

import java.util.List;

public class CategoryUseCase implements ICategoryServicePort {

    private final ICategoryPersistencePort categoryPersistencePort;

    public CategoryUseCase(ICategoryPersistencePort categoryPersistencePort) {
        this.categoryPersistencePort = categoryPersistencePort;
    }

    @Override
    public Category saveCategory(Category category) {
        return categoryPersistencePort.saveCategory(category);
    }

    @Override
    public Category getCategory(String name) {
        return categoryPersistencePort.getCategory(name);
    }

    @Override
    public List<Category> getAllCategories(Integer page, Integer size,String sortOrder) {
        return categoryPersistencePort.getAllCategories(page, size,sortOrder);
    }
}