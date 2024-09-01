package com.emazon.categoria.configuration;

import com.emazon.categoria.adapters.driven.jpa.mysql.adapter.CategoryAdapter;
import com.emazon.categoria.adapters.driven.jpa.mysql.mapper.ICategoryEntityMapper;
import com.emazon.categoria.adapters.driven.jpa.mysql.repository.ICategoryRepository;
import com.emazon.categoria.domain.api.ICategoryServicePort;
import com.emazon.categoria.domain.api.usecase.CategoryUseCase;
import com.emazon.categoria.domain.spi.ICategoryPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private final ICategoryRepository categoryRepository;
    private final ICategoryEntityMapper categoryEntityMapper;

    @Bean
    public ICategoryPersistencePort categoryPersistencePort() {
        return new CategoryAdapter(categoryRepository, categoryEntityMapper);
    }

    @Bean
    public ICategoryServicePort categoryServicePort() {
        return new CategoryUseCase(categoryPersistencePort());
    }
}