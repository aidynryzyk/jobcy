package kz.aidyninho.jobcy.controller;

import kz.aidyninho.jobcy.dto.JobFilter;
import kz.aidyninho.jobcy.entity.City;
import kz.aidyninho.jobcy.entity.JobType;
import kz.aidyninho.jobcy.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
@SessionAttributes(value = {"userId", "filter"})
public class JobController {

    private final JobService jobService;
    private final CategoryService categoryService;
    private final ExperienceService experienceService;
    private final KeywordService keywordService;
    private final IndustryService industryService;

    @Autowired
    public JobController(JobService jobService,
                         CategoryService categoryService,
                         ExperienceService experienceService,
                         KeywordService keywordService,
                         IndustryService industryService) {
        this.jobService = jobService;
        this.categoryService = categoryService;
        this.experienceService = experienceService;
        this.keywordService = keywordService;
        this.industryService = industryService;
    }

    @GetMapping
    public String index(Model model, Authentication authentication) {
        return "index";
    }

    @GetMapping("/job-categories")
    public String jobCategories(Model model) {
        model.addAttribute("categories", categoryService.findAllWithJobsCount());
        return "job-categories";
    }

    @GetMapping("/jobs")
    public String findAll(Model model, JobFilter filter) {
        model.addAttribute("cities", City.values());
        model.addAttribute("categories", categoryService.findAllWithJobsCount());
        model.addAttribute("experiences", experienceService.findAll());
        model.addAttribute("types", JobType.values());
        model.addAttribute("keywords", keywordService.findAll());
        model.addAttribute("filter", filter);
        return "job-list";
    }

    @GetMapping("/jobs/{id}")
    public String jobDetailsPage(Model model, @PathVariable Long id, Authentication authentication) {
        model.addAttribute("jobId", id);
        return "job-details";
    }

    @GetMapping("/users/user/jobs/post/{id}")
    public String jobPostPage(Model model, @PathVariable Long id, @RequestParam(required = false) String isUserId) {
        if (isUserId != null) {
            model.addAttribute("job", null);
            model.addAttribute("userId", id);
        } else {
            model.addAttribute("job", jobService.findById(id));
        }
        model.addAttribute("cities", City.values());
        model.addAttribute("industries", industryService.findAll());
        model.addAttribute("categories", categoryService.findAllWithJobsCount());
        model.addAttribute("types", JobType.values());
        model.addAttribute("keywords", keywordService.findAll());
        model.addAttribute("experiences", experienceService.findAll());

        return "manage-jobs-post";
    }

    @GetMapping("/jobs/{id}/applications")
    public String candidatesPage(Model model, @PathVariable Long id) {
        model.addAttribute("jobId", id);
        return "candidate-list";
    }

    @GetMapping("/about")
    public String aboutPage() {
        return "about";
    }

    @GetMapping("/services")
    public String servicesPage() {
        return "services";
    }

    @GetMapping("/team")
    public String teamPage() {
        return "team";
    }

    @GetMapping("/pricing")
    public String pricingPage() {
        return "pricing";
    }

    @GetMapping("/privacy")
    public String privacyPage() {
        return "privacy-policy";
    }

    @GetMapping("/faq")
    public String faqPage() {
        return "faqs";
    }

    @GetMapping("/blog")
    public String blogPage() {
        return "blog";
    }

    @GetMapping("/contact")
    public String contactPage() {
        return "contact";
    }
}
