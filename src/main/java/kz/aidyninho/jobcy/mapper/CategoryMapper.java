package kz.aidyninho.jobcy.mapper;

import kz.aidyninho.jobcy.dto.CategoryDto;
import kz.aidyninho.jobcy.entity.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryDto toDto(Category category);

    Category toModel(CategoryDto categoryDto);
}
