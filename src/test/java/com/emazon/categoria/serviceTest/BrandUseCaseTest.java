package com.emazon.categoria.serviceTest;
import com.emazon.categoria.domain.api.usecase.BrandUseCase;
import com.emazon.categoria.domain.model.Brand;
import com.emazon.categoria.domain.spi.IBrandPersistencePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.doThrow;
public class BrandUseCaseTest {

    @Mock
    private IBrandPersistencePort brandPersistencePort;

    @InjectMocks
    private BrandUseCase brandUseCase;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSaveBrand_Success() {

        Brand brand = new Brand(null, "Adidas", "Sportswear");
        Brand savedBrand = new Brand(1L, "Adidas", "Sportswear");


        when(brandPersistencePort.saveBrand(any(Brand.class))).thenReturn(savedBrand);


        Brand result = brandUseCase.saveBrand(brand);


        assertEquals(savedBrand.getId(), result.getId());
        assertEquals(savedBrand.getName(), result.getName());
    }

    @Test
    public void testSaveBrand_NameAlreadyExists() {

        Brand brand = new Brand(null, "Adidas", "Sportswear");


        doThrow(new IllegalArgumentException("Brand name already exists")).when(brandPersistencePort).saveBrand(any(Brand.class));


        try {
            brandUseCase.saveBrand(brand);
        } catch (IllegalArgumentException e) {
            assertEquals("Brand name already exists", e.getMessage());
        }
    }
}
