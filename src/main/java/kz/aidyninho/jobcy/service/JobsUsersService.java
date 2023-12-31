package kz.aidyninho.jobcy.service;

import kz.aidyninho.jobcy.dto.JobsUsersCreateDto;
import kz.aidyninho.jobcy.dto.JobsUsersReadJobDto;
import kz.aidyninho.jobcy.dto.JobsUsersReadUserDto;
import kz.aidyninho.jobcy.entity.JobsUsers;
import kz.aidyninho.jobcy.mapper.JobsUsersMapper;
import kz.aidyninho.jobcy.repository.JobRepository;
import kz.aidyninho.jobcy.repository.JobsUsersRepository;
import kz.aidyninho.jobcy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class JobsUsersService {

    private final JobsUsersRepository jobsUsersRepository;
    private final JobRepository jobRepository;
    private final UserRepository userRepository;
    private final JobsUsersMapper jobsUsersMapper;

    @Autowired
    public JobsUsersService(JobsUsersRepository jobsUsersRepository, JobRepository jobRepository, UserRepository userRepository, JobsUsersMapper jobsUsersMapper) {
        this.jobsUsersRepository = jobsUsersRepository;
        this.jobRepository = jobRepository;
        this.userRepository = userRepository;
        this.jobsUsersMapper = jobsUsersMapper;
    }

    public List<JobsUsersReadUserDto> findAllByJobId(Long jobId) {
        return jobsUsersRepository.findAllByJob_IdOrderByIdAsc(jobId).stream().map(
                jobsUsersMapper::toReadUserDto
        ).toList();
    }

    public List<JobsUsersReadJobDto> findAllByUserId(Long userId) {
        return jobsUsersRepository.findAllByUser_Id(userId).stream().map(
                jobsUsersMapper::toReadJobDto
        ).toList();
    }

    @Transactional
    public void save(JobsUsersCreateDto jobsUsersCreateDto) {
        JobsUsers jobsUsers = new JobsUsers();
        jobsUsers.setJob(jobRepository.findById(jobsUsersCreateDto.getJobId()).get());
        jobsUsers.setUser(userRepository.findById(jobsUsersCreateDto.getUserId()).get());
        jobsUsers.setMessage(jobsUsersCreateDto.getMessage());
        jobsUsersRepository.saveAndFlush(jobsUsers);
    }

}
