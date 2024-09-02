package com.emazon.categoria.domain.api;

import com.emazon.categoria.domain.model.Brand;
import com.emazon.categoria.domain.model.Category;

import java.util.List;


public interface IBrandServicePort {
  Brand saveBrand(Brand brand);
  List<Brand> getAllbrans(Integer page, Integer size, String sortOrder);

}
