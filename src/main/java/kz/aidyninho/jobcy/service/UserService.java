package kz.aidyninho.jobcy.service;

import kz.aidyninho.jobcy.dto.JobReadDto;
import kz.aidyninho.jobcy.dto.UserEditDto;
import kz.aidyninho.jobcy.dto.UserImageDto;
import kz.aidyninho.jobcy.dto.UserReadDto;
import kz.aidyninho.jobcy.entity.User;
import kz.aidyninho.jobcy.mapper.JobMapper;
import kz.aidyninho.jobcy.mapper.UserMapper;
import kz.aidyninho.jobcy.repository.UserRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collections;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final ImageService imageService;
    private final UserMapper userMapper;
    private final JobMapper jobMapper;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository,
                       UserMapper userMapper,
                       ImageService imageService,
                       JobMapper jobMapper,
                       PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.imageService = imageService;
        this.passwordEncoder = passwordEncoder;
        this.jobMapper = jobMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username).map(
                user -> new org.springframework.security.core.userdetails.User(
                        user.getUsername(),
                        user.getPassword(),
                        Collections.singleton(user.getRole())
                )
        ).orElseThrow(() -> new UsernameNotFoundException("Failed to retrieve user " + username));
    }

    public List<UserReadDto> findAll() {
        return userRepository.findAll().stream().map(
                userMapper::toReadDto
        ).toList();
    }

    @Transactional
    public void save(UserReadDto userReadDto) {
        User user = userMapper.toModel(userReadDto);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Transactional
    public void update(UserEditDto userEditDto) {
        User user = userRepository.findById(userEditDto.getId()).get();
        userMapper.copy(user, userEditDto, passwordEncoder);
        userRepository.saveAndFlush(user);
    }

    @Transactional
    public void updateImage(UserImageDto userImageDto) {
        User user = userRepository.findById(userImageDto.getId()).get();
        user.setImage(userImageDto.getImage().getOriginalFilename());
        uploadImage(userImageDto.getImage());
        userRepository.saveAndFlush(user);
    }

    @SneakyThrows
    private void uploadImage(MultipartFile image) {
        imageService.upload(image.getOriginalFilename(), image.getInputStream());
    }

    public UserReadDto findById(Long id) {
        return userMapper.toReadDto(userRepository.findById(id).get());
    }

    public UserReadDto findByUsername(String username) {
        return userMapper.toReadDto(userRepository.findByUsername(username).get());
    }

    public List<JobReadDto> findJobsByUser(Long userId) {
        return userRepository.findById(userId).get().getJobs().stream().map(
                jobMapper::toReadDto
        ).toList();
    }
}
