package kz.aidyninho.jobcy.mapper;

import kz.aidyninho.jobcy.dto.UserEditDto;
import kz.aidyninho.jobcy.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserEditMapper implements Mapper<UserEditDto, User> {

    private final PasswordEncoder passwordEncoder;

    @Override
    public User mapFrom(UserEditDto object) {
        User user = new User();
        copy(user, object);
        return user;
    }

    public void copy(User user, UserEditDto object) {
        if (object.getRawPassword() != null && object.getNewPassword() != null) {
            if (passwordEncoder.matches(object.getRawPassword(), user.getPassword())) {
                user.setPassword(passwordEncoder.encode(object.getNewPassword()));
            }
        }
        user.setFullName(object.getFullName());
        user.setEmail(object.getEmail());
        user.setDescription(object.getDescription());
        user.setPhone(object.getPhone());
        user.setWhatsapp(object.getWhatsapp());
        user.setInstagram(object.getInstagram());
    }
}
