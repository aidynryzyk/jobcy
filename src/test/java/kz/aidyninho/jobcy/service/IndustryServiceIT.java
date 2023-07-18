package kz.aidyninho.jobcy.service;

import kz.aidyninho.jobcy.dto.IndustryDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class IndustryServiceIT extends IntegrationTestBase {

    @Autowired
    private IndustryService industryService;

    @Test
    void findAll() {
        List<IndustryDto> actual = industryService.findAll();
        assertNotNull(actual);
        assertFalse(actual.isEmpty());
        assertEquals(2, actual.size());
        actual.forEach(industryDto -> assertInstanceOf(IndustryDto.class, industryDto));
    }
}