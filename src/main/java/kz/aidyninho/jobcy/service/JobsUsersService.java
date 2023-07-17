package kz.aidyninho.jobcy.service;

import kz.aidyninho.jobcy.dto.JobDto;
import kz.aidyninho.jobcy.dto.JobsUsersDto;
import kz.aidyninho.jobcy.dto.JobsUsersReadDto;
import kz.aidyninho.jobcy.dto.JobsUsersReadForUserDto;
import kz.aidyninho.jobcy.entity.JobsUsers;
import kz.aidyninho.jobcy.repository.JobRepository;
import kz.aidyninho.jobcy.repository.JobsUsersRepository;
import kz.aidyninho.jobcy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobsUsersService {

    private JobsUsersRepository jobsUsersRepository;
    private JobRepository jobRepository;
    private UserRepository userRepository;

    @Autowired
    public JobsUsersService(JobsUsersRepository jobsUsersRepository, JobRepository jobRepository, UserRepository userRepository) {
        this.jobsUsersRepository = jobsUsersRepository;
        this.jobRepository = jobRepository;
        this.userRepository = userRepository;
    }

    public List<JobsUsersReadDto> findAllByJobId(Long jobId) {
        return jobsUsersRepository.findAllByJob_Id(jobId).stream().map(
                jobsUsers -> new JobsUsersReadDto(
                        jobsUsers.getJob().getId(),
                        jobsUsers.getUser(),
                        jobsUsers.getMessage()
                )
        ).toList();
    }

    public List<JobsUsersReadForUserDto> findAllByUserId(Long userId) {
        return jobsUsersRepository.findAllByUser_Id(userId).stream().map(
                jobsUsers -> new JobsUsersReadForUserDto(
                        new JobDto(
                                jobsUsers.getJob().getId(),
                                jobsUsers.getJob().getName(),
                                jobsUsers.getJob().getUser(),
                                jobsUsers.getJob().getExperience(),
                                jobsUsers.getJob().getLocation(),
                                jobsUsers.getJob().getSalary(),
                                jobsUsers.getJob().getQualification(),
                                jobsUsers.getJob().getPostDate(),
                                jobsUsers.getJob().getDescription(),
                                jobsUsers.getJob().getType(),
                                jobsUsers.getJob().getIndustry(),
                                jobsUsers.getJob().getCategory(),
                                jobsUsers.getJob().getKeywords()
                        ),
                        jobsUsers.getUser().getId(),
                        jobsUsers.getMessage()
                )
        ).toList();
    }

    public void save(JobsUsersDto jobsUsersDto) {
        JobsUsers jobsUsers = new JobsUsers();
        jobsUsers.setJob(jobRepository.findById(jobsUsersDto.jobId()).get());
        jobsUsers.setUser(userRepository.findById(jobsUsersDto.userId()).get());
        jobsUsers.setMessage(jobsUsersDto.message());
        jobsUsersRepository.save(jobsUsers);
    }

}
