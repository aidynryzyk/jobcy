package kz.aidyninho.jobcy.service;

import kz.aidyninho.jobcy.dto.ExperienceDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ExperienceServiceIT extends IntegrationTestBase {

    @Autowired
    private ExperienceService experienceService;

    @Test
    void findAll() {
        List<ExperienceDto> actual = experienceService.findAll();
        assertNotNull(actual);
        assertFalse(actual.isEmpty());
        assertEquals(2, actual.size());
        actual.forEach(experienceDto -> assertInstanceOf(ExperienceDto.class, experienceDto));
    }
}