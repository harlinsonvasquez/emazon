package com.emazon.categoria.adapters.driving.http.mapper;

import com.emazon.categoria.adapters.driving.http.dtos.response.BrandResponse;
import com.emazon.categoria.adapters.driving.http.dtos.response.CategoryResponse;
import com.emazon.categoria.domain.model.Brand;
import com.emazon.categoria.domain.model.Category;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IBrandResponseMapper {
    BrandResponse toResponse(Brand brand);
    List<BrandResponse> toResponseList(List<Brand> brands);
}
