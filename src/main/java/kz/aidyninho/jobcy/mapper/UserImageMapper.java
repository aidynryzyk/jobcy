package kz.aidyninho.jobcy.mapper;

import kz.aidyninho.jobcy.dto.UserImageDto;
import kz.aidyninho.jobcy.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;
import java.util.function.Predicate;

@Component
@RequiredArgsConstructor
public class UserImageMapper implements Mapper<UserImageDto, User> {

    @Override
    public User mapFrom(UserImageDto object) {
        User user = new User();
        copy(user, object);
        return user;
    }

    public void copy(User user, UserImageDto object) {
        Optional.ofNullable(object.getImage())
                .filter(Predicate.not(MultipartFile::isEmpty))
                .ifPresent(image -> user.setImage(image.getOriginalFilename()));
    }
}
