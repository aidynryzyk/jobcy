package kz.aidyninho.jobcy.service;

import kz.aidyninho.jobcy.entity.Keyword;
import kz.aidyninho.jobcy.repository.KeywordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KeywordService {

    private KeywordRepository keywordRepository;

    @Autowired
    public KeywordService(KeywordRepository keywordRepository) {
        this.keywordRepository = keywordRepository;
    }

    public List<Keyword> findAll() {
        return keywordRepository.findAll();
    }
}
