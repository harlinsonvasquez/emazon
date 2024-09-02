package com.emazon.categoria.controllerTest;
import com.emazon.categoria.adapters.driving.http.controller.BrandController;
import com.emazon.categoria.adapters.driving.http.dtos.request.BrandRequest;
import com.emazon.categoria.adapters.driving.http.dtos.response.BrandResponse;
import com.emazon.categoria.adapters.driving.http.mapper.IBrandRequestMapper;
import com.emazon.categoria.adapters.driving.http.mapper.IBrandResponseMapper;
import com.emazon.categoria.domain.api.IBrandServicePort;
import com.emazon.categoria.domain.model.Brand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
public class BrandControllerTest {

    @Mock
    private IBrandServicePort brandServicePort;

    @Mock
    private IBrandRequestMapper brandRequestMapper;

    @Mock
    private IBrandResponseMapper brandResponseMapper;

    @InjectMocks
    private BrandController brandController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddBrand_Success() {

        BrandRequest request = new BrandRequest("Nike", "Sportswear");


        Brand brand = new Brand(null, "Nike", "Sportswear");
        Brand savedBrand = new Brand(1L, "Nike", "Sportswear");
        BrandResponse brandResponse = new BrandResponse(1L, "Nike", "Sportswear");

        when(brandRequestMapper.toModel(request)).thenReturn(brand);
        when(brandServicePort.saveBrand(any(Brand.class))).thenReturn(savedBrand);
        when(brandResponseMapper.toResponse(savedBrand)).thenReturn(brandResponse);


        ResponseEntity<BrandResponse> response = brandController.addBrand(request);


        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(brandResponse, response.getBody());
    }

    @Test
    public void testAddBrand_NameAlreadyExists() {

        BrandRequest request = new BrandRequest("Nike", "Sportswear");


        Brand brand = new Brand(null, "Nike", "Sportswear");


        when(brandRequestMapper.toModel(request)).thenReturn(brand);
        when(brandServicePort.saveBrand(any(Brand.class))).thenThrow(new IllegalArgumentException("Brand name already exists"));


        try {
            brandController.addBrand(request);
        } catch (IllegalArgumentException e) {
            assertEquals("Brand name already exists", e.getMessage());
        }
    }
}
