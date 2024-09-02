package com.emazon.categoria.adapters.driving.http.dtos.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BrandRequest {
    @NotBlank
    private  String name;
    @NotBlank
    private  String description;
}
