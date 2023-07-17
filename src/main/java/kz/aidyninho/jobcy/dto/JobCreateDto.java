package kz.aidyninho.jobcy.dto;

import kz.aidyninho.jobcy.entity.JobType;
import kz.aidyninho.jobcy.entity.Keyword;

import java.time.LocalDateTime;
import java.util.List;

public record JobCreateDto(Long id,
                           String name,
                           Long userId,
                           String companyName,
                           Long experienceId,
                           String location,
                           Integer salary,
                           String qualification,
                           LocalDateTime postDate,
                           String description,
                           JobType type,
                           Long categoryId,
                           List<Keyword> keywords) {
}
