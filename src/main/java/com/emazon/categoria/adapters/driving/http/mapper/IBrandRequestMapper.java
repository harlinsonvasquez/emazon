package com.emazon.categoria.adapters.driving.http.mapper;

import com.emazon.categoria.adapters.driving.http.dtos.request.AddCategoryRequest;
import com.emazon.categoria.adapters.driving.http.dtos.request.BrandRequest;
import com.emazon.categoria.domain.model.Brand;
import com.emazon.categoria.domain.model.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IBrandRequestMapper {
    Brand toModel(BrandRequest brandRequest);
}
