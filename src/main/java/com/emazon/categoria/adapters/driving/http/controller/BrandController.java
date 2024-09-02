package com.emazon.categoria.adapters.driving.http.controller;

import com.emazon.categoria.adapters.driving.http.dtos.request.BrandRequest;
import com.emazon.categoria.adapters.driving.http.dtos.response.BrandResponse;
import com.emazon.categoria.adapters.driving.http.dtos.response.CategoryResponse;
import com.emazon.categoria.adapters.driving.http.mapper.IBrandRequestMapper;
import com.emazon.categoria.adapters.driving.http.mapper.IBrandResponseMapper;
import com.emazon.categoria.domain.api.IBrandServicePort;
import com.emazon.categoria.domain.model.Brand;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping("/getAll")
    public ResponseEntity<List<BrandResponse>> getAllBrands(
            @RequestParam Integer page,
            @RequestParam Integer size,
            @RequestParam(defaultValue = "asc") String sortOrder) {


        sortOrder = sortOrder.trim();

        if (!sortOrder.equalsIgnoreCase("asc") && !sortOrder.equalsIgnoreCase("desc")) {
            throw new IllegalArgumentException("Invalid sortOrder value. Must be 'asc' or 'desc'.");
        }

        List<BrandResponse> brands = brandResponseMapper.toResponseList(
                brandServicePort.getAllbrans(page, size, sortOrder.trim())
        );
        return ResponseEntity.ok(brands);
    }
}
