package kz.aidyninho.jobcy.mapper;

import kz.aidyninho.jobcy.dto.IndustryDto;
import kz.aidyninho.jobcy.dto.KeywordDto;
import kz.aidyninho.jobcy.entity.Industry;
import kz.aidyninho.jobcy.entity.Keyword;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IndustryMapper {

    IndustryDto toDto(Industry industry);

    Industry toModel(IndustryDto industryDto);
}
