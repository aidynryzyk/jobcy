package kz.aidyninho.jobcy.dto;

import kz.aidyninho.jobcy.entity.JobType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class JobEditDto {

    private Long id;
    private String name;
    private ExperienceDto experience;
    private String location;
    private Integer salary;
    private String qualification;
    private LocalDateTime postDate;
    private String description;
    private JobType type;
    private IndustryDto industry;
    private CategoryDto category;
    private List<KeywordDto> keywords;
}
