package kz.aidyninho.jobcy.service;

import kz.aidyninho.jobcy.dto.CategoryDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CategoryServiceIT extends IntegrationTestBase {

    @Autowired
    private CategoryService categoryService;

    @Test
    void findAll() {
        List<CategoryDto> actual = categoryService.findAllWithJobsCount();
        assertNotNull(actual);
        assertFalse(actual.isEmpty());
        assertEquals(2, actual.size());
        actual.forEach(categoryDto -> assertInstanceOf(CategoryDto.class, categoryDto));
    }
}