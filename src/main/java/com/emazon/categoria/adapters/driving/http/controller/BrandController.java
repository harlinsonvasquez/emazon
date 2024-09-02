package com.emazon.categoria.adapters.driving.http.controller;

import com.emazon.categoria.adapters.driving.http.dtos.request.BrandRequest;
import com.emazon.categoria.adapters.driving.http.dtos.response.BrandResponse;
import com.emazon.categoria.adapters.driving.http.mapper.IBrandRequestMapper;
import com.emazon.categoria.adapters.driving.http.mapper.IBrandResponseMapper;
import com.emazon.categoria.domain.api.IBrandServicePort;
import com.emazon.categoria.domain.model.Brand;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/brands")
@RequiredArgsConstructor
public class BrandController {
    private final IBrandServicePort brandServicePort;
    private final IBrandResponseMapper brandResponseMapper;
    private final IBrandRequestMapper brandRequestMapper;

    @PostMapping("/createBrand")
    public ResponseEntity<BrandResponse> addBrand(@RequestBody BrandRequest request) {

        Brand brand = brandRequestMapper.toModel(request);
        Brand savedBrand = brandServicePort.saveBrand(brand);
        BrandResponse brandResponse = brandResponseMapper.toResponse(savedBrand);

        return ResponseEntity.status(HttpStatus.CREATED).body(brandResponse);
    }
}
