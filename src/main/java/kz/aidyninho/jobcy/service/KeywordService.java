package kz.aidyninho.jobcy.service;

import kz.aidyninho.jobcy.dto.KeywordDto;
import kz.aidyninho.jobcy.mapper.KeywordMapper;
import kz.aidyninho.jobcy.repository.KeywordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KeywordService {

    private final KeywordRepository keywordRepository;
    private final KeywordMapper keywordMapper;

    @Autowired
    public KeywordService(KeywordRepository keywordRepository, KeywordMapper keywordMapper) {
        this.keywordRepository = keywordRepository;
        this.keywordMapper = keywordMapper;
    }

    public List<KeywordDto> findAll() {
        return keywordRepository.findAll().stream().map(
                keywordMapper::toDto
        ).toList();
    }
}
