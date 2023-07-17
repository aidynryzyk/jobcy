package kz.aidyninho.jobcy.dto;

import kz.aidyninho.jobcy.entity.*;

import java.time.LocalDateTime;
import java.util.List;

public record JobDto(Long id,
                     String name,
                     User user,
                     Experience experience,
                     String location,
                     Integer salary,
                     String qualification,
                     LocalDateTime postDate,
                     String description,
                     JobType type,
                     Industry industry,
                     Category category,
                     List<Keyword> keywords) {
}
