package kz.aidyninho.jobcy.specification;

import jakarta.persistence.criteria.Predicate;
import kz.aidyninho.jobcy.dto.KeywordDto;
import kz.aidyninho.jobcy.entity.Job;
import kz.aidyninho.jobcy.entity.JobType;
import kz.aidyninho.jobcy.entity.Keyword;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class JobSpecification {

    public static Specification<Job> getJobs(String name,
                                             String location,
                                             Integer categoryId,
                                             Integer experience,
                                             JobType type,
                                             String postDate,
                                             List<Keyword> keywords) {
        return ((jobs, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (name != null) {
                predicates.add(cb.like(cb.lower(jobs.get("name")), "%" + name.toLowerCase() + "%"));
            }
            if (location != null) {
                predicates.add(cb.like(cb.lower(jobs.get("location")), "%" + location.toLowerCase() + "%"));
            }
            if (categoryId != null) {
                predicates.add(cb.equal(jobs.get("category").get("id"), categoryId));
            }
            if (experience != null) {
                predicates.add(cb.equal(jobs.get("experience").get("id"), experience));
            }
            if (type != null) {
                predicates.add(cb.equal(jobs.get("type"), type));
            }
            if (postDate != null) {
                predicates.add(cb.greaterThanOrEqualTo(jobs.get("postDate"), LocalDateTime.parse(postDate)));
            }
            if (keywords != null) {
                for (Keyword keyword : keywords) {
                    predicates.add(cb.isMember(keyword, jobs.get("keywords")));
                }
            }
            return cb.and(predicates.toArray(Predicate[]::new));
        });
    }
}
