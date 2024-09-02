package com.emazon.categoria.domain.api.usecase;

import com.emazon.categoria.domain.api.IBrandServicePort;
import com.emazon.categoria.domain.model.Brand;
import com.emazon.categoria.domain.spi.IBrandPersistencePort;

public class BrandUseCase implements IBrandServicePort {
    private final IBrandPersistencePort brandPersistencePort;

    public BrandUseCase(IBrandPersistencePort brandPersistencePort) {
        this.brandPersistencePort = brandPersistencePort;
    }

    @Override
    public Brand saveBrand(Brand brand) {
        return brandPersistencePort.saveBrand(brand);
    }
}
