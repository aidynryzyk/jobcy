package kz.aidyninho.jobcy.api;

import kz.aidyninho.jobcy.dto.CategoryDto;
import kz.aidyninho.jobcy.dto.JobCreateDto;
import kz.aidyninho.jobcy.dto.JobReadDto;
import kz.aidyninho.jobcy.dto.JobFilter;
import kz.aidyninho.jobcy.entity.City;
import kz.aidyninho.jobcy.entity.JobType;
import kz.aidyninho.jobcy.service.CategoryService;
import kz.aidyninho.jobcy.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class JobRestController {

    private final JobService jobService;
    private final CategoryService categoryService;

    @Autowired
    public JobRestController(JobService jobService, CategoryService categoryService) {
        this.jobService = jobService;
        this.categoryService = categoryService;
    }

    @GetMapping("/jobs")
    public Page<JobReadDto> findAll(Pageable pageable) {
        JobFilter filter = jobService.getFilter();
        if (filter == null) {
            filter = new JobFilter();
        }
        return jobService.findAllByFilter(filter, pageable);
    }

    @GetMapping("/jobs/{id}")
    public JobReadDto find(@PathVariable Long id) {
        return jobService.findById(id);
    }

    @DeleteMapping("/jobs/{id}")
    public void delete(@PathVariable Long id) {
        jobService.deleteJob(id);
    }

    @GetMapping("/categories")
    public List<CategoryDto> findAllCategories() {
        return categoryService.findAllWithJobsCount();
    }

    @GetMapping("/types")
    public List<JobType> findAllTypes() {
        return List.of(JobType.values());
    }

    @GetMapping("/cities")
    public List<City> findAllCities() {
        return List.of(City.values());
    }

    @GetMapping("/jobs/previews")
    public List<JobReadDto> findTop4JobsByTypeOrderedByPostDate(@RequestParam String type) {
        return jobService.findTop4ByTypeOrderByPostDateDesc(JobType.valueOf(type));
    }

    @GetMapping("/jobs/filter")
    public JobFilter findFilter() {
        return jobService.getFilter();
    }

    @PostMapping("/jobs/filter")
    public void saveFilter(@RequestBody JobFilter filter) {
        jobService.saveFilter(filter);
    }

    @PostMapping("/users/user/jobs")
    public void saveJob(@RequestBody JobCreateDto jobCreateDto) {
        jobService.saveJob(jobCreateDto);
    }

    @PutMapping("/users/user/jobs")
    public void updateJob(@RequestBody JobCreateDto jobCreateDto) {
        jobService.updateJob(jobCreateDto);
    }

}
