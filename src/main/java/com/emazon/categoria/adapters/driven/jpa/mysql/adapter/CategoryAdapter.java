package com.emazon.categoria.adapters.driven.jpa.mysql.adapter;

import com.emazon.categoria.adapters.driven.jpa.mysql.mapper.ICategoryEntityMapper;
import com.emazon.categoria.adapters.driven.jpa.mysql.repository.ICategoryRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CategoryAdapter implements ICategoryPersistencePort{
    private final ICategoryRepository categoryRepository;
    private final ICategoryEntityMapper categoryEntityMapper;

    @Override
    public void saveCategory(Category category) {
        if (categoryRepository.findByName(category.getName()).isPresent()) {
            throw new CategoryAlreadyExistsException();
        }
        categoryRepository.save(categoryEntityMapper.toEntity(category));
    }

    @Override
    public Category getCategory(String name) {
        CategoryEntity category = categoryRepository.findByName(name)
                .orElseThrow(ElementNotFoundException::new);
        return categoryEntityMapper.toModel(category);
    }

    @Override
    public List<Category> getAllCategories(Integer page, Integer size) {
        Pageable pagination = PageRequest.of(page, size);
        List<CategoryEntity> categories = categoryRepository.findAll(pagination).getContent();
        if (categories.isEmpty()) {
            throw new NoDataFoundException();
        }
        return categoryEntityMapper.toModelList(categories);
    }
}
