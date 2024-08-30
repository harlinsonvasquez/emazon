package com.emazon.categoria.adapters.driving.http.mapper;

import com.emazon.categoria.adapters.driving.http.dtos.request.AddCategoryRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ICategoryRequestMapper {
    Category toModel(AddCategoryRequest addCategoryRequest);
}
