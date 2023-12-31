package kz.aidyninho.jobcy.dto;

import kz.aidyninho.jobcy.entity.*;
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
public class JobCreateDto {

    private Long id;
    private String name;
    private Long userId;
    private Long experienceId;
    private String location;
    private Integer salary;
    private String qualification;
    private LocalDateTime postDate;
    private String description;
    private JobType type;
    private Long industryId;
    private Long categoryId;
    private List<KeywordDto> keywords;
}
