package kz.aidyninho.jobcy.controller;

import kz.aidyninho.jobcy.dto.UserImageDto;
import kz.aidyninho.jobcy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.security.Principal;

@Controller
@SessionAttributes(value = {"userId"})
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/sign-in")
    public String signIn() {
        return "sign-in";
    }

    @GetMapping("/profile")
    public String profile(Model model, Authentication authentication) {
        model.addAttribute("userId", userService.findByUsername(authentication.getName()).getId());
        return "profile";
    }

    @GetMapping("/profile/{id}")
    public String profileOfAnotherUser(Model model, @PathVariable Long id, Authentication authentication) {
        model.addAttribute("userId", userService.findByUsername(authentication.getName()).getId());
        model.addAttribute("profileId", id);
        return "profile";
    }

    @GetMapping("/sign-out")
    public String signOut() {
        return "sign-out";
    }

    @GetMapping("/sign-up")
    public String signUpPage() {
        return "sign-up";
    }

    @PostMapping("/sign-up")
    public String signUp() {
        return "sign-up";
    }

    @GetMapping("/manage-jobs")
    public String manageJobsPage(Model model, Authentication authentication) {
        model.addAttribute("userId", userService.findByUsername(authentication.getName()).getId());
        return "manage-jobs";
    }

    @GetMapping("/applied-jobs")
    public String appliedJobsPage(Model model, Authentication authentication) {
        model.addAttribute("userId", userService.findByUsername(authentication.getName()).getId());
        return "applied-jobs";
    }

    @PostMapping("/users/image")
    public String uploadImage(UserImageDto userImageDto) {
        userService.updateImage(userImageDto);
        return "redirect:/profile/" + userImageDto.getId();
    }

}
