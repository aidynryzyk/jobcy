package kz.aidyninho.jobcy.api;

import kz.aidyninho.jobcy.dto.JobReadDto;
import kz.aidyninho.jobcy.dto.UserEditDto;
import kz.aidyninho.jobcy.dto.UserImageDto;
import kz.aidyninho.jobcy.dto.UserReadDto;
import kz.aidyninho.jobcy.service.ImageService;
import kz.aidyninho.jobcy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/api/v1")
public class UserRestController {

    private UserService userService;
    private ImageService imageService;

    @Autowired
    public UserRestController(UserService userService, ImageService imageService) {
        this.userService = userService;
        this.imageService = imageService;
    }

    @PostMapping("/users")
    public void save(@RequestBody UserReadDto userReadDto) {
        userService.save(userReadDto);
    }

    @GetMapping("/users/{id}")
    public UserReadDto find(@PathVariable Long id) {
        return userService.findById(id);
    }

    @GetMapping("/users/user")
    public UserReadDto getUser(Authentication authentication) {
        if (authentication == null) {
            return null;
        }
        return userService.findByUsername(authentication.getName());
    }

    @GetMapping("/users/user/jobs")
    public List<JobReadDto> getJobs(Authentication authentication) {
        return userService.findJobsByUser(getUser(authentication).getId());
    }

    @PutMapping("/users/update")
    public void updateUser(@RequestBody UserEditDto userEditDto) {
        userService.update(userEditDto);
    }

    @PostMapping("/users/user/image")
    public void postImage(@RequestBody UserImageDto userImageDto) {
        userService.updateImage(userImageDto);
    }

    @GetMapping("/users/{id}/image")
    public byte[] getImage(@PathVariable Long id) {
        UserReadDto userReadDto = userService.findById(id);
        if (userReadDto.getImage() != null) {
            return imageService.get(userReadDto.getImage()).get();
        }
        throw new ResponseStatusException(NOT_FOUND);
    }
}
