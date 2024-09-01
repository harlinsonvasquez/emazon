package com.emazon.categoria.adapters.driven.jpa.mysql.adapter;

import com.emazon.categoria.adapters.driven.jpa.mysql.entity.CategoryEntity;
import com.emazon.categoria.adapters.driven.jpa.mysql.exception.CategoryAlreadyExistsException;
import com.emazon.categoria.adapters.driven.jpa.mysql.exception.NoDataFoundException;
import com.emazon.categoria.adapters.driven.jpa.mysql.exception.ElementNotFoundException;
import com.emazon.categoria.adapters.driven.jpa.mysql.mapper.ICategoryEntityMapper;
import com.emazon.categoria.adapters.driven.jpa.mysql.repository.ICategoryRepository;
import com.emazon.categoria.domain.model.Category;
import com.emazon.categoria.domain.spi.ICategoryPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;


public class CategoryAdapter implements ICategoryPersistencePort {
    private final ICategoryRepository categoryRepository;
    private final ICategoryEntityMapper categoryEntityMapper;

    public CategoryAdapter(ICategoryRepository categoryRepository, ICategoryEntityMapper categoryEntityMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryEntityMapper = categoryEntityMapper;
    }

    @Override
    public Category saveCategory(Category category) {
        if (categoryRepository.findByName(category.getName()).isPresent()) {
            throw new CategoryAlreadyExistsException();
        }
        CategoryEntity savedEntity = categoryRepository.save(categoryEntityMapper.toEntity(category)); // Aquí obtenemos la entidad guardada
        return categoryEntityMapper.toModel(savedEntity);
    }

    @Override
    public Category getCategory(String name) {
        CategoryEntity category = categoryRepository.findByName(name)
                .orElseThrow(ElementNotFoundException::new);
        return categoryEntityMapper.toModel(category);
    }

    @Override
    public List<Category> getAllCategories(Integer page, Integer size,String sortOrder) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sortOrder), "name"));
        List<CategoryEntity> categories = categoryRepository.findAll(pageable).getContent();
        if (categories.isEmpty()) {
            throw new NoDataFoundException();
        }
        return categoryEntityMapper.toModelList(categories);
    }
}
