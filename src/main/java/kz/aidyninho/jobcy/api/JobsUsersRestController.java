package kz.aidyninho.jobcy.api;

import kz.aidyninho.jobcy.dto.JobsUsersCreateDto;
import kz.aidyninho.jobcy.dto.JobsUsersReadJobDto;
import kz.aidyninho.jobcy.dto.JobsUsersReadUserDto;
import kz.aidyninho.jobcy.service.JobsUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class JobsUsersRestController {

    private JobsUsersService jobsUsersService;

    @Autowired
    public JobsUsersRestController(JobsUsersService jobsUsersService) {
        this.jobsUsersService = jobsUsersService;
    }

    @PostMapping("/jobs-users/apply")
    public void applyUserForJob(@RequestBody JobsUsersCreateDto jobsUsersCreateDto) {
        jobsUsersService.save(jobsUsersCreateDto);
    }

    @GetMapping("/jobs-users/job/{id}")
    public List<JobsUsersReadUserDto> findByJob(@PathVariable Long id) {
        return jobsUsersService.findAllByJobId(id);
    }

    @GetMapping("/jobs-users/user/{id}")
    public List<JobsUsersReadJobDto> findByUser(@PathVariable Long id) {
        return jobsUsersService.findAllByUserId(id);
    }
}
