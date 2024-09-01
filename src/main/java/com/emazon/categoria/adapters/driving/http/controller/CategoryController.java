package com.emazon.categoria.adapters.driving.http.controller;

import com.emazon.categoria.adapters.driving.http.dtos.request.AddCategoryRequest;
import com.emazon.categoria.adapters.driving.http.dtos.response.CategoryResponse;
import com.emazon.categoria.adapters.driving.http.mapper.ICategoryRequestMapper;
import com.emazon.categoria.adapters.driving.http.mapper.ICategoryResponseMapper;
import com.emazon.categoria.domain.api.ICategoryServicePort;
import com.emazon.categoria.domain.model.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final ICategoryServicePort categoryServicePort;
    private final ICategoryResponseMapper categoryResponseMapper;

    @PostMapping("/createCategory")
    public ResponseEntity<CategoryResponse> addCategory(@RequestBody AddCategoryRequest request) {
        Category category = new Category(null, request.getName(), request.getDescription());
        Category savedCategory = categoryServicePort.saveCategory(category);

        CategoryResponse categoryResponse = categoryResponseMapper.toResponse(savedCategory);

        return ResponseEntity.status(HttpStatus.CREATED).body(categoryResponse);
    }

    @GetMapping("/{name}")
    public ResponseEntity<CategoryResponse> getCategory(@PathVariable String name) {
        return ResponseEntity.ok(categoryResponseMapper.toResponse(categoryServicePort.getCategory(name)));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<CategoryResponse>> getAllCategories(
            @RequestParam Integer page,
            @RequestParam Integer size,
            @RequestParam(defaultValue = "asc") String sortOrder) {


        sortOrder = sortOrder.trim();

        if (!sortOrder.equalsIgnoreCase("asc") && !sortOrder.equalsIgnoreCase("desc")) {
            throw new IllegalArgumentException("Invalid sortOrder value. Must be 'asc' or 'desc'.");
        }

        List<CategoryResponse> categories = categoryResponseMapper.toResponseList(
                categoryServicePort.getAllCategories(page, size, sortOrder.trim())
        );
        return ResponseEntity.ok(categories);
    }

}
