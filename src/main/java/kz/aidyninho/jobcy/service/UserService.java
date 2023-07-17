package kz.aidyninho.jobcy.service;

import kz.aidyninho.jobcy.dto.JobDto;
import kz.aidyninho.jobcy.dto.UserDto;
import kz.aidyninho.jobcy.dto.UserEditDto;
import kz.aidyninho.jobcy.dto.UserImageDto;
import kz.aidyninho.jobcy.mapper.UserEditMapper;
import kz.aidyninho.jobcy.mapper.UserMapper;
import kz.aidyninho.jobcy.repository.UserRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collections;
import java.util.List;

@Service
public class UserService implements UserDetailsService {

    private UserRepository userRepository;
    private UserMapper userMapper;
    private ImageService imageService;
    private UserEditMapper userEditMapper;

    @Autowired
    public UserService(UserRepository userRepository, UserMapper userMapper, ImageService imageService, UserEditMapper userEditMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.imageService = imageService;
        this.userEditMapper = userEditMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username).map(
                user -> new User(
                        user.getUsername(),
                        user.getPassword(),
                        Collections.singleton(user.getRole())
                )
        ).orElseThrow(() -> new UsernameNotFoundException("Failed to retrieve user " + username));
    }

    public UserDto save(UserDto userDto) {
        kz.aidyninho.jobcy.entity.User user = userMapper.mapFrom(userDto);
        userRepository.save(user);
        return userDto;
    }

    public void update(UserEditDto userEditDto) {
        kz.aidyninho.jobcy.entity.User user = userRepository.findById(userEditDto.getId()).get();
        userEditMapper.copy(user, userEditDto);
        userRepository.saveAndFlush(user);
    }

    public void updateImage(UserImageDto userImageDto) {
        kz.aidyninho.jobcy.entity.User user = userRepository.findById(userImageDto.getId()).get();
        user.setImage(userImageDto.getImage().getOriginalFilename());
        uploadImage(userImageDto.getImage());
        userRepository.saveAndFlush(user);
    }

    @SneakyThrows
    private void uploadImage(MultipartFile image) {
        imageService.upload(image.getOriginalFilename(), image.getInputStream());
    }

    public UserDto findById(Long id) {
        return userRepository.findById(id).stream().map(user -> userMapper.mapTo(user)).findFirst().get();
    }

    public UserDto findByUsername(String username) {
        return userRepository.findByUsername(username).stream().map(user -> userMapper.mapTo(user)).findFirst().get();
    }

    public List<JobDto> findJobsByUser(Long userId) {
        return userRepository.findById(userId).get().getJobs().stream().map(
                job -> new JobDto(
                        job.getId(),
                        job.getName(),
                        job.getUser(),
                        job.getExperience(),
                        job.getLocation(),
                        job.getSalary(),
                        job.getQualification(),
                        job.getPostDate(),
                        job.getDescription(),
                        job.getType(),
                        job.getIndustry(),
                        job.getCategory(),
                        job.getKeywords()
                )
        ).toList();
    }
}
