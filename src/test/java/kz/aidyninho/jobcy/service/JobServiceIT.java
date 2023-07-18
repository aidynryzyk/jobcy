package kz.aidyninho.jobcy.service;

import kz.aidyninho.jobcy.dto.JobCreateDto;
import kz.aidyninho.jobcy.dto.JobReadDto;
import kz.aidyninho.jobcy.entity.JobType;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class JobServiceIT extends IntegrationTestBase {

    @Autowired
    private JobService jobService;

    @Test
    @Order(1)
    void findAll() {
        List<JobReadDto> actual = jobService.findAll();
        assertNotNull(actual);
        assertFalse(actual.isEmpty());
        assertEquals(2, actual.size());
        actual.forEach(jobReadDto -> assertInstanceOf(JobReadDto.class, jobReadDto));
    }

    @Test
    @Order(2)
    void findAllByFilter() {
        Page<JobReadDto> actual = jobService.findAllByFilter(jobService.getFilter(), Pageable.ofSize(10));
        assertNotNull(actual);
        assertFalse(actual.isEmpty());
        assertEquals(2, actual.getTotalElements());
        assertEquals(1, actual.getTotalPages());
        actual.forEach(jobReadDto -> assertInstanceOf(JobReadDto.class, jobReadDto));
    }

    @Test
    @Order(3)
    void findById() {
        JobReadDto actual = jobService.findById(1L);
        assertNotNull(actual);
        assertEquals("Java Developer", actual.getName());
    }

    @Test
    @Order(4)
    void findTop4ByType() {
        List<JobReadDto> actual = jobService.findTop4ByTypeOrderByPostDateDesc(JobType.Fulltime);
        assertNotNull(actual);
        assertEquals(1, actual.size());
        assertEquals("Java Developer", actual.get(0).getName());
    }

    @Test
    @Order(5)
    void saveJob() {
        JobCreateDto actual = new JobCreateDto();
        actual.setUserId(1L);
        actual.setName("new");
        actual.setExperienceId(1L);
        actual.setCategoryId(1L);
        actual.setIndustryId(1L);
        jobService.saveJob(actual);
        assertNotNull(jobService.findById(3L));
        assertEquals("new", jobService.findById(3L).getName());
    }

    @Test
    @Order(6)
    void updateJob() {
        JobCreateDto actual = new JobCreateDto();
        actual.setId(1L);
        actual.setName("updated");
        actual.setUserId(1L);
        actual.setExperienceId(1L);
        actual.setCategoryId(1L);
        actual.setIndustryId(1L);
        actual.setKeywords(new ArrayList<>());
        jobService.updateJob(actual);
        assertNotNull(jobService.findById(1L));
        assertEquals("updated", jobService.findById(1L).getName());
    }

    @Test
    @Order(7)
    void deleteJob() {
        assertEquals(3, jobService.findAll().size());
        jobService.deleteJob(3L);
        assertEquals(2, jobService.findAll().size());
    }
}