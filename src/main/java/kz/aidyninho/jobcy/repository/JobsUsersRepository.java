package kz.aidyninho.jobcy.repository;

import kz.aidyninho.jobcy.entity.JobsUsers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobsUsersRepository extends JpaRepository<JobsUsers, Long> {

    List<JobsUsers> findAllByJob_IdOrderByIdAsc(Long jobId);

    List<JobsUsers> findAllByUser_Id(Long userId);
}
