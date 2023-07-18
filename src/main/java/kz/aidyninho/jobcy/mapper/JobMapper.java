package kz.aidyninho.jobcy.mapper;

import kz.aidyninho.jobcy.dto.JobCreateDto;
import kz.aidyninho.jobcy.dto.JobEditDto;
import kz.aidyninho.jobcy.dto.JobReadDto;
import kz.aidyninho.jobcy.entity.Job;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface JobMapper {

    JobReadDto toReadDto(Job job);

    Job toModel(JobReadDto jobDto);

    JobCreateDto toCreateDto(Job job);

    Job toModel(JobCreateDto jobCreateDto);

}
