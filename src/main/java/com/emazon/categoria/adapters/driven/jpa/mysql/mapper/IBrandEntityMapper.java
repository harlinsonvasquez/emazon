package com.emazon.categoria.adapters.driven.jpa.mysql.mapper;
import com.emazon.categoria.adapters.driven.jpa.mysql.entity.BrandEntity;
import com.emazon.categoria.adapters.driven.jpa.mysql.entity.CategoryEntity;
import com.emazon.categoria.domain.model.Brand;
import com.emazon.categoria.domain.model.Category;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IBrandEntityMapper {
    Brand toModel(BrandEntity brandEntity);
    BrandEntity toEntity(Brand brand);
    List<Brand> toModelList(List<BrandEntity> brandEntities);
}
