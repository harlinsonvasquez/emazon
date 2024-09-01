package com.emazon.categoria.serviceTest;
import com.emazon.categoria.domain.api.usecase.CategoryUseCase;
import com.emazon.categoria.domain.model.Category;
import com.emazon.categoria.domain.spi.ICategoryPersistencePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class CategoryUseCaseTest {

    @Mock
    private ICategoryPersistencePort categoryPersistencePort;

    @InjectMocks
    private CategoryUseCase categoryUseCase;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllCategories() {

        Category category1 = new Category(1L, "Electronics", "Devices and gadgets");
        Category category2 = new Category(2L, "Books", "Books of all genres");

        List<Category> mockCategories = Arrays.asList(category1, category2);


        when(categoryPersistencePort.getAllCategories(anyInt(), anyInt(), anyString())).thenReturn(mockCategories);


        List<Category> categories = categoryUseCase.getAllCategories(0, 10, "asc");


        assertEquals(2, categories.size());
        assertEquals("Electronics", categories.get(0).getName());
        assertEquals("Books", categories.get(1).getName());
    }

    @Test
    public void testSaveCategory() {

        Category category = new Category(1L, "Furniture", "Home and office furniture");


        when(categoryPersistencePort.saveCategory(category)).thenReturn(category);


        Category savedCategory = categoryUseCase.saveCategory(category);


        assertEquals("Furniture", savedCategory.getName());
        assertEquals("Home and office furniture", savedCategory.getDescription());
    }
}
