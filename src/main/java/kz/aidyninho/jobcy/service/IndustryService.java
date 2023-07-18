package kz.aidyninho.jobcy.service;

import kz.aidyninho.jobcy.dto.IndustryDto;
import kz.aidyninho.jobcy.mapper.IndustryMapper;
import kz.aidyninho.jobcy.repository.IndustryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndustryService {

    private IndustryRepository industryRepository;
    private IndustryMapper industryMapper;

    @Autowired
    public IndustryService(IndustryRepository industryRepository, IndustryMapper industryMapper) {
        this.industryRepository = industryRepository;
        this.industryMapper = industryMapper;
    }

    public List<IndustryDto> findAll() {
        return industryRepository.findAll().stream().map(
                industry -> industryMapper.toDto(industry)
        ).toList();
    }
}
