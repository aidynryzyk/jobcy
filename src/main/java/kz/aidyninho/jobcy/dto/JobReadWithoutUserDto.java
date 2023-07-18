package kz.aidyninho.jobcy.dto;

import kz.aidyninho.jobcy.entity.Category;
import kz.aidyninho.jobcy.entity.Experience;
import kz.aidyninho.jobcy.entity.Industry;
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
public class JobReadWithoutUserDto {

    private Long id;
    private String name;
    private Long userId;
    private Experience experience;
    private String location;
    private Integer salary;
    private String qualification;
    private LocalDateTime postDate;
    private String description;
    private JobType type;
    private Industry industry;
    private Category category;
    private List<KeywordDto> keywords;
}
