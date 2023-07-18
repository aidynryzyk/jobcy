package kz.aidyninho.jobcy.mapper;

import kz.aidyninho.jobcy.dto.JobsUsersCreateDto;
import kz.aidyninho.jobcy.dto.JobsUsersReadJobDto;
import kz.aidyninho.jobcy.dto.JobsUsersReadUserDto;
import kz.aidyninho.jobcy.entity.JobsUsers;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface JobsUsersMapper {

    JobsUsersReadJobDto toReadJobDto(JobsUsers jobsUsers);

    JobsUsers toModel(JobsUsersReadJobDto jobsUsersReadJobDto);

    JobsUsersReadUserDto toReadUserDto(JobsUsers jobsUsers);

    JobsUsers toModel(JobsUsersReadUserDto jobsUsersReadUserDto);

    JobsUsersCreateDto toCreateDto(JobsUsers jobsUsers);

    JobsUsers toModel(JobsUsersCreateDto jobsUsersCreateDto);
}
