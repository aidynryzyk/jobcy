package kz.aidyninho.jobcy.service;

import kz.aidyninho.jobcy.dto.CategoryDto;
import kz.aidyninho.jobcy.mapper.CategoryMapper;
import kz.aidyninho.jobcy.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    public List<CategoryDto> findAllWithJobsCount() {
        return categoryRepository.findAll().stream()
                .map(
                        category -> {
                            CategoryDto categoryDto = categoryMapper.toDto(category);
                            categoryDto.setJobsCount(categoryRepository.countJobsByCategory(categoryDto.getId()));
                            return categoryDto;
                        }
                ).sorted(
                        Comparator.comparingInt(CategoryDto::getJobsCount)
                                .reversed()
                ).toList();
    }
}
