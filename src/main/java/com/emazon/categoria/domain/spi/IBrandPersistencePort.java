package com.emazon.categoria.domain.spi;

import com.emazon.categoria.domain.model.Brand;
import com.emazon.categoria.domain.model.Category;


import java.util.List;

public interface IBrandPersistencePort {
    Brand saveBrand(Brand brand);
    List<Brand> getAllbrans(Integer page, Integer size, String sortOrder);

}
