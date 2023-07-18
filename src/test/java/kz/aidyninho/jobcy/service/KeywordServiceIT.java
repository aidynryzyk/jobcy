package kz.aidyninho.jobcy.service;

import kz.aidyninho.jobcy.dto.KeywordDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class KeywordServiceIT extends IntegrationTestBase {

    @Autowired
    private KeywordService keywordService;

    @Test
    void findAll() {
        List<KeywordDto> actual = keywordService.findAll();
        assertNotNull(actual);
        assertFalse(actual.isEmpty());
        assertEquals(2, actual.size());
        actual.forEach(keywordDto -> assertInstanceOf(KeywordDto.class, keywordDto));
    }
}