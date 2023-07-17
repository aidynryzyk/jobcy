package kz.aidyninho.jobcy.api;

import kz.aidyninho.jobcy.dto.JobDto;
import kz.aidyninho.jobcy.dto.UserDto;
import kz.aidyninho.jobcy.dto.UserEditDto;
import kz.aidyninho.jobcy.dto.UserImageDto;
import kz.aidyninho.jobcy.service.ImageService;
import kz.aidyninho.jobcy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

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
    public void save(@RequestBody UserDto user) {
        userService.save(user);
    }

    @GetMapping("/users/{id}")
    public UserDto find(@PathVariable Long id) {
        return userService.findById(id);
    }

    @GetMapping("/users/user")
    public UserDto getUser(Authentication authentication) {
        if (authentication == null) {
            return null;
        }
        return userService.findByUsername(authentication.getName());
    }

    @GetMapping("/users/user/jobs")
    public List<JobDto> getJobs(Authentication authentication) {
        return userService.findJobsByUser(getUser(authentication).getId());
    }

    @PutMapping("/users/update")
    public void updateUser(@RequestBody UserEditDto userDto) {
        userService.update(userDto);
    }

    @PostMapping("/users/user/image")
    public void postImage(@RequestBody UserImageDto userImageDto) {
        userService.updateImage(userImageDto);
    }

    @GetMapping("/users/{id}/image")
    public byte[] getImage(@PathVariable Long id) {
        UserDto userDto = userService.findById(id);
        if (userDto.getImage() != null) {
            return imageService.get(userDto.getImage()).get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
}
