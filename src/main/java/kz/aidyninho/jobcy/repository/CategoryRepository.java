package kz.aidyninho.jobcy.repository;

import kz.aidyninho.jobcy.entity.Category;
import kz.aidyninho.jobcy.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Query(value = "select count(*) from jobs where category_id = :category_id", nativeQuery = true)
    Integer countJobsByCategory(@Param("category_id") Long id);

}
