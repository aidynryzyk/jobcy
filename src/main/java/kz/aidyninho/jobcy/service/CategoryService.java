package kz.aidyninho.jobcy.service;

import kz.aidyninho.jobcy.dto.CategoryDto;
import kz.aidyninho.jobcy.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<CategoryDto> findAllWithJobsCount() {
        return categoryRepository.findAll().stream()
                .map(
                        category -> new CategoryDto(
                                category.getId(),
                                category.getName(),
                                category.getIcon(),
                                categoryRepository.countJobsByCategory(category.getId())
                        )
                ).sorted(Comparator.comparingInt(CategoryDto::jobsCount).reversed()).toList();
    }
}
