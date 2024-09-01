package com.emazon.categoria.controllerTest;

import com.emazon.categoria.adapters.driving.http.controller.CategoryController;
import com.emazon.categoria.adapters.driving.http.dtos.request.AddCategoryRequest;
import com.emazon.categoria.adapters.driving.http.dtos.response.CategoryResponse;
import com.emazon.categoria.adapters.driving.http.mapper.ICategoryRequestMapper;
import com.emazon.categoria.adapters.driving.http.mapper.ICategoryResponseMapper;
import com.emazon.categoria.domain.api.ICategoryServicePort;
import com.emazon.categoria.domain.model.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class CategoryControllerTest {

    @Mock
    private ICategoryServicePort categoryServicePort;

    @Mock
    private ICategoryResponseMapper categoryResponseMapper;

    @InjectMocks
    private CategoryController categoryController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddCategory() {

        AddCategoryRequest request = new AddCategoryRequest("Furniture", "Home and office furniture");
        Category category = new Category(null, "Furniture", "Home and office furniture");
        Category savedCategory = new Category(1L, "Furniture", "Home and office furniture");
        CategoryResponse categoryResponse = new CategoryResponse(1L, "Furniture", "Home and office furniture");


        when(categoryServicePort.saveCategory(any(Category.class))).thenReturn(savedCategory);
        when(categoryResponseMapper.toResponse(savedCategory)).thenReturn(categoryResponse);


        ResponseEntity<CategoryResponse> response = categoryController.addCategory(request);


        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(categoryResponse, response.getBody());
    }

    @Test
    public void testGetAllCategories() {

        Category category1 = new Category(1L, "Electronics", "Devices and gadgets");
        Category category2 = new Category(2L, "Books", "Books of all genres");
        List<Category> mockCategories = Arrays.asList(category1, category2);

        CategoryResponse response1 = new CategoryResponse(1L, "Electronics", "Devices and gadgets");
        CategoryResponse response2 = new CategoryResponse(2L, "Books", "Books of all genres");
        List<CategoryResponse> mockResponses = Arrays.asList(response1, response2);


        when(categoryServicePort.getAllCategories(anyInt(), anyInt(), anyString())).thenReturn(mockCategories);
        when(categoryResponseMapper.toResponseList(mockCategories)).thenReturn(mockResponses);


        ResponseEntity<List<CategoryResponse>> response = categoryController.getAllCategories(0, 10, "asc");


        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(2, response.getBody().size());
        assertEquals("Electronics", response.getBody().get(0).getName());
        assertEquals("Books", response.getBody().get(1).getName());
    }
}