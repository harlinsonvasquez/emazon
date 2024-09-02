package com.emazon.categoria.adapters.driven.jpa.mysql.adapter;

import com.emazon.categoria.adapters.driven.jpa.mysql.entity.BrandEntity;
import com.emazon.categoria.adapters.driven.jpa.mysql.exception.BrandAlreadyExistsException;
import com.emazon.categoria.adapters.driven.jpa.mysql.mapper.IBrandEntityMapper;
import com.emazon.categoria.adapters.driven.jpa.mysql.repository.IBrandRepository;
import com.emazon.categoria.domain.model.Brand;
import com.emazon.categoria.domain.spi.IBrandPersistencePort;

public class BrandAdapter implements IBrandPersistencePort {
    private final IBrandRepository brandRepository;
    private final IBrandEntityMapper brandEntityMapper;

    public BrandAdapter(IBrandRepository brandRepository, IBrandEntityMapper brandEntityMapper) {
        this.brandRepository = brandRepository;
        this.brandEntityMapper = brandEntityMapper;
    }
    @Override
    public Brand saveBrand(Brand brand) {
        if(brandRepository.findByName(brand.getName()).isPresent()){
            throw new BrandAlreadyExistsException();
        }
        BrandEntity savedBrandEntity = brandRepository.save(brandEntityMapper.toEntity(brand));
        return brandEntityMapper.toModel(savedBrandEntity);
    }
}
