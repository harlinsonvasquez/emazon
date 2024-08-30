package com.emazon.categoria.adapters.driving.http.dtos.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class AddCategoryRequest {
    @NotBlank
    private final String name;
    @NotBlank
    private final String description;
}
