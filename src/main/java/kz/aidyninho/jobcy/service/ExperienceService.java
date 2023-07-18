package kz.aidyninho.jobcy.service;

import kz.aidyninho.jobcy.dto.ExperienceDto;
import kz.aidyninho.jobcy.mapper.ExperienceMapper;
import kz.aidyninho.jobcy.repository.ExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExperienceService {

    private final ExperienceRepository experienceRepository;
    private final ExperienceMapper experienceMapper;

    @Autowired
    public ExperienceService(ExperienceRepository experienceRepository, ExperienceMapper experienceMapper) {
        this.experienceRepository = experienceRepository;
        this.experienceMapper = experienceMapper;
    }

    public List<ExperienceDto> findAll() {
        return experienceRepository.findAll().stream().map(
                experience -> experienceMapper.toDto(experience)
        ).toList();
    }
}
