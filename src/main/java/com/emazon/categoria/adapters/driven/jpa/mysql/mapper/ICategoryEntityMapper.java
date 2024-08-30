package com.emazon.categoria.adapters.driven.jpa.mysql.mapper;
import com.emazon.categoria.adapters.driven.jpa.mysql.entity.CategoryEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ICategoryEntityMapper {
    Category toModel(CategoryEntity categoryEntity);
    CategoryEntity toEntity(Category category);
    List<Category> toModelList(List<CategoryEntity> categoryEntities);>
}
