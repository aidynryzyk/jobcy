package kz.aidyninho.jobcy.api;

import kz.aidyninho.jobcy.dto.JobsUsersDto;
import kz.aidyninho.jobcy.dto.JobsUsersReadDto;
import kz.aidyninho.jobcy.dto.JobsUsersReadForUserDto;
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
    public void applyUserForJob(@RequestBody JobsUsersDto jobsUsersDto) {
        jobsUsersService.save(jobsUsersDto);
    }

    @GetMapping("/jobs-users/job/{id}")
    public List<JobsUsersReadDto> findByJob(@PathVariable Long id) {
        return jobsUsersService.findAllByJobId(id);
    }

    @GetMapping("/jobs-users/user/{id}")
    public List<JobsUsersReadForUserDto> findByUser(@PathVariable Long id) {
        return jobsUsersService.findAllByUserId(id);
    }
}
