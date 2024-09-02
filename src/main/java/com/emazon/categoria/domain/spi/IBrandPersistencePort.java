package com.emazon.categoria.domain.spi;

import com.emazon.categoria.domain.model.Brand;


import java.util.List;

public interface IBrandPersistencePort {
    Brand saveBrand(Brand brand);

}
