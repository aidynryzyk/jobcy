package kz.aidyninho.jobcy.repository;

import kz.aidyninho.jobcy.entity.Category;
import kz.aidyninho.jobcy.entity.Job;
import kz.aidyninho.jobcy.entity.JobType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Type;
import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<Job, Long>, JpaSpecificationExecutor<Job> {

    List<Job> findTop4ByTypeOrderByPostDateDesc(JobType type);

}
