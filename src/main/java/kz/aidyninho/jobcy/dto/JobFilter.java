package kz.aidyninho.jobcy.dto;

import kz.aidyninho.jobcy.entity.JobType;
import kz.aidyninho.jobcy.entity.Keyword;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class JobFilter {

    private String name;
    private String location;
    private Integer categoryId;
    private Integer experience;
    private JobType type;
    private String postDate;
    private List<Keyword> keywords;
}
