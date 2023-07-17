package kz.aidyninho.jobcy.service;

import kz.aidyninho.jobcy.dto.JobCreateDto;
import kz.aidyninho.jobcy.dto.JobDto;
import kz.aidyninho.jobcy.dto.JobFilter;
import kz.aidyninho.jobcy.entity.Job;
import kz.aidyninho.jobcy.entity.JobType;
import kz.aidyninho.jobcy.repository.*;
import kz.aidyninho.jobcy.specification.JobSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    private JobRepository jobRepository;
    private UserRepository userRepository;
    private CategoryRepository categoryRepository;
    private ExperienceRepository experienceRepository;
    private IndustryRepository industryRepository;
    private JobFilter jobFilter = new JobFilter();

    @Autowired
    public JobService(JobRepository jobRepository,
                      UserRepository userRepository,
                      CategoryRepository categoryRepository,
                      ExperienceRepository experienceRepository,
                      IndustryRepository industryRepository) {
        this.jobRepository = jobRepository;
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
        this.experienceRepository = experienceRepository;
        this.industryRepository = industryRepository;
    }

    public Page<JobDto> findAllByFilter(JobFilter filter, Pageable pageable) {

        return jobRepository.findAll(JobSpecification.getJobs(
                filter.getName(),
                filter.getLocation(),
                filter.getCategoryId(),
                filter.getExperience(),
                filter.getType(),
                filter.getPostDate(),
                filter.getKeywords()
        ), pageable).map(
                job -> new JobDto(
                        job.getId(),
                        job.getName(),
                        job.getUser(),
                        job.getExperience(),
                        job.getLocation(),
                        job.getSalary(),
                        job.getQualification(),
                        job.getPostDate(),
                        job.getDescription(),
                        job.getType(),
                        job.getIndustry(),
                        job.getCategory(),
                        job.getKeywords()
                )
        );
    }

    public List<JobDto> findTop4ByTypeOrderByPostDateDesc(JobType type) {
        return jobRepository.findTop4ByTypeOrderByPostDateDesc(type).stream()
                .map(
                        job -> new JobDto(
                                job.getId(),
                                job.getName(),
                                job.getUser(),
                                job.getExperience(),
                                job.getLocation(),
                                job.getSalary(),
                                job.getQualification(),
                                job.getPostDate(),
                                job.getDescription(),
                                job.getType(),
                                job.getIndustry(),
                                job.getCategory(),
                                job.getKeywords()
                        )
                ).toList();
    }

    public JobFilter getFilter() {
        return jobFilter;
    }

    public void saveFilter(JobFilter jobFilter) {
        this.jobFilter = jobFilter;
    }

    public void saveJob(JobCreateDto jobDto) {
        Job job = new Job();
        job.setId(jobDto.id());
        job.setName(jobDto.name());
        job.setUser(userRepository.findById(jobDto.userId()).get());
        job.setExperience(experienceRepository.findById(jobDto.experienceId()).get());
        job.setLocation(jobDto.location());
        job.setSalary(jobDto.salary());
        job.setQualification(jobDto.qualification());
        job.setPostDate(jobDto.postDate());
        job.setDescription(jobDto.description());
        job.setType(jobDto.type());
        job.setCategory(categoryRepository.findById(jobDto.categoryId()).get());
        job.setKeywords(jobDto.keywords());
        jobRepository.saveAndFlush(job);
    }

    public void deleteJob(Long id) {
        jobRepository.deleteById(id);
        jobRepository.flush();
    }

    public JobDto findById(Long id) {
        return jobRepository.findById(id)
                .map(
                        job -> new JobDto(
                                job.getId(),
                                job.getName(),
                                job.getUser(),
                                job.getExperience(),
                                job.getLocation(),
                                job.getSalary(),
                                job.getQualification(),
                                job.getPostDate(),
                                job.getDescription(),
                                job.getType(),
                                job.getIndustry(),
                                job.getCategory(),
                                job.getKeywords()
                        )
                ).get();
    }

}
