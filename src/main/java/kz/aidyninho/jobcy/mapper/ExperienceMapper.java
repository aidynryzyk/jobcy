package kz.aidyninho.jobcy.mapper;

import kz.aidyninho.jobcy.dto.CategoryDto;
import kz.aidyninho.jobcy.dto.ExperienceDto;
import kz.aidyninho.jobcy.entity.Category;
import kz.aidyninho.jobcy.entity.Experience;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ExperienceMapper {

    ExperienceDto toDto(Experience experience);

    Experience toModel(ExperienceDto experienceDto);
}
