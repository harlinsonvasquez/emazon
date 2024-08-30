package com.emazon.categoria.adapters.driving.http.mapper;

import com.emazon.categoria.adapters.driving.http.dtos.response.CategoryResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ICategoryResponseMapper {
    CategoryResponse toResponse(Category category);
    List<CategoryResponse> toResponseList(List<Category> categories);
}
