package kz.aidyninho.jobcy.mapper;

import kz.aidyninho.jobcy.dto.CategoryDto;
import kz.aidyninho.jobcy.dto.KeywordDto;
import kz.aidyninho.jobcy.entity.Category;
import kz.aidyninho.jobcy.entity.Keyword;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface KeywordMapper {

    KeywordDto toDto(Keyword keyword);

    Keyword toModel(KeywordDto keywordDto);
}
