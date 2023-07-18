package kz.aidyninho.jobcy.service;

import kz.aidyninho.jobcy.dto.JobCreateDto;
import kz.aidyninho.jobcy.dto.JobEditDto;
import kz.aidyninho.jobcy.dto.JobReadDto;
import kz.aidyninho.jobcy.dto.JobFilter;
import kz.aidyninho.jobcy.entity.Job;
import kz.aidyninho.jobcy.entity.JobType;
import kz.aidyninho.jobcy.mapper.*;
import kz.aidyninho.jobcy.repository.*;
import kz.aidyninho.jobcy.specification.JobSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class JobService {

    private JobRepository jobRepository;
    private UserRepository userRepository;
    private CategoryRepository categoryRepository;
    private ExperienceRepository experienceRepository;
    private IndustryRepository industryRepository;
    private JobMapper jobMapper;
    private ExperienceMapper experienceMapper;
    private CategoryMapper categoryMapper;
    private IndustryMapper industryMapper;
    private KeywordMapper keywordMapper;
    private JobFilter jobFilter = new JobFilter();

    @Autowired
    public JobService(JobRepository jobRepository,
                      UserRepository userRepository,
                      CategoryRepository categoryRepository,
                      ExperienceRepository experienceRepository,
                      IndustryRepository industryRepository, JobMapper jobMapper, ExperienceMapper experienceMapper, CategoryMapper categoryMapper, IndustryMapper industryMapper, KeywordMapper keywordMapper) {
        this.jobRepository = jobRepository;
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
        this.experienceRepository = experienceRepository;
        this.industryRepository = industryRepository;
        this.jobMapper = jobMapper;
        this.experienceMapper = experienceMapper;
        this.categoryMapper = categoryMapper;
        this.industryMapper = industryMapper;
        this.keywordMapper = keywordMapper;
    }

    public Page<JobReadDto> findAllByFilter(JobFilter filter, Pageable pageable) {

        return jobRepository.findAll(JobSpecification.getJobs(
                filter.getName(),
                filter.getLocation(),
                filter.getCategoryId(),
                filter.getExperience(),
                filter.getType(),
                filter.getPostDate(),
                filter.getKeywords()
        ), pageable).map(
                job -> jobMapper.toReadDto(job)
        );
    }

    public List<JobReadDto> findTop4ByTypeOrderByPostDateDesc(JobType type) {
        return jobRepository.findTop4ByTypeOrderByPostDateDesc(type).stream()
                .map(
                        job -> jobMapper.toReadDto(job)
                ).toList();
    }

    public JobFilter getFilter() {
        return jobFilter;
    }

    @Transactional
    public void saveFilter(JobFilter jobFilter) {
        this.jobFilter = jobFilter;
    }

    @Transactional
    public void saveJob(JobCreateDto jobCreateDto) {
        Job job = jobMapper.toModel(jobCreateDto);
        job.setUser(userRepository.findById(jobCreateDto.getUserId()).get());
        job.setExperience(experienceRepository.findById(jobCreateDto.getExperienceId()).get());
        job.setIndustry(industryRepository.findById(jobCreateDto.getIndustryId()).get());
        job.setCategory(categoryRepository.findById(jobCreateDto.getCategoryId()).get());
        jobRepository.saveAndFlush(job);
    }

    @Transactional
    public void deleteJob(Long id) {
        jobRepository.deleteById(id);
        jobRepository.flush();
    }

    public JobReadDto findById(Long id) {
        return jobRepository.findById(id)
                .map(
                        job -> jobMapper.toReadDto(job)
                ).get();
    }

    @Transactional
    public void updateJob(JobCreateDto jobCreateDto) {
        Job job = jobRepository.findById(jobCreateDto.getId()).get();
        job.setName(jobCreateDto.getName());
        job.setExperience(experienceRepository.findById(jobCreateDto.getExperienceId()).get());
        job.setLocation(jobCreateDto.getLocation());
        job.setSalary(jobCreateDto.getSalary());
        job.setQualification(jobCreateDto.getQualification());
        job.setPostDate(jobCreateDto.getPostDate());
        job.setDescription(jobCreateDto.getDescription());
        job.setType(jobCreateDto.getType());
        job.setIndustry(industryRepository.findById(jobCreateDto.getIndustryId()).get());
        job.setCategory(categoryRepository.findById(jobCreateDto.getCategoryId()).get());
        if (!jobCreateDto.getKeywords().isEmpty()) {
            job.setKeywords(jobCreateDto.getKeywords().stream()
                    .map(
                            keywordDto -> keywordMapper.toModel(keywordDto)
                    ).toList());
        }
        jobRepository.save(job);
    }
}
