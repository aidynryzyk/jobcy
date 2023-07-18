package kz.aidyninho.jobcy.mapper;

import kz.aidyninho.jobcy.dto.UserReadDto;
import kz.aidyninho.jobcy.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserMapper2 implements Mapper<UserReadDto, User> {
    @Override
    public User mapFrom(UserReadDto object) {
        return null;
    }

//    private final PasswordEncoder passwordEncoder;
//
//    @Override
//    public User mapFrom(UserDto object) {
//        User user = new User();
//        copy(user, object);
//        return user;
//    }
//
//    public UserDto mapTo(User object) {
//        UserDto userDto = new UserDto();
//        userDto.setUsername(object.getUsername());
//        userDto.setId(object.getId());
//        userDto.setEmail(object.getEmail());
//        userDto.setPassword(object.getPassword());
//        userDto.setRole(object.getRole());
//        userDto.setJobs(object.getJobs().stream().map(job -> new JobReadDto(
//                job.getId(),
//                job.getName(),
//                job.getUser(),
//                job.getExperience(),
//                job.getLocation(),
//                job.getSalary(),
//                job.getQualification(),
//                job.getPostDate(),
//                job.getDescription(),
//                job.getType(),
//                job.getIndustry(),
//                job.getCategory(),
//                job.getKeywords()
//        )).toList());
//        userDto.setFullName(object.getFullName());
//        userDto.setDescription(object.getDescription());
//        userDto.setPhone(object.getPhone());
//        userDto.setWhatsapp(object.getWhatsapp());
//        userDto.setInstagram(object.getInstagram());
//        userDto.setImage(object.getImage());
//        return userDto;
//    }
//
//    private void copy(User user, UserDto object) {
//        user.setUsername(object.getUsername());
//        user.setEmail(object.getEmail());
//        user.setPassword(passwordEncoder.encode(object.getPassword()));
//        user.setRole(object.getRole());
//        user.setJobs(object.getJobs().stream().map(jobDto -> {
//            Job job = new Job();
//            job.setId(jobDto.id());
//            job.setName(jobDto.name());
//            job.setUser(jobDto.user());
//            job.setExperience(jobDto.experience());
//            job.setLocation(jobDto.location());
//            job.setSalary(jobDto.salary());
//            job.setQualification(jobDto.qualification());
//            job.setPostDate(jobDto.postDate());
//            job.setDescription(jobDto.description());
//            job.setType(jobDto.type());
//            job.setIndustry(jobDto.industry());
//            job.setCategory(jobDto.category());
//            job.setKeywords(jobDto.keywords());
//            return job;
//        }).toList());
//        user.setFullName(object.getFullName());
//        user.setDescription(object.getDescription());
//        user.setPhone(object.getPhone());
//        user.setWhatsapp(object.getWhatsapp());
//        user.setInstagram(object.getInstagram());
//        user.setImage(object.getImage());
//    }
}
