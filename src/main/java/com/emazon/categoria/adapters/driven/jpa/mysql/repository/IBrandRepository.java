package com.emazon.categoria.adapters.driven.jpa.mysql.repository;

import com.emazon.categoria.adapters.driven.jpa.mysql.entity.BrandEntity;
import com.emazon.categoria.adapters.driven.jpa.mysql.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IBrandRepository extends JpaRepository<BrandEntity, Long> {
    Optional<BrandEntity> findByName(String name);
}
