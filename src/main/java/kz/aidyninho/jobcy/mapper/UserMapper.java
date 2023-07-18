package kz.aidyninho.jobcy.mapper;

import kz.aidyninho.jobcy.dto.*;
import kz.aidyninho.jobcy.entity.Job;
import kz.aidyninho.jobcy.entity.User;
import org.mapstruct.Mapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.multipart.MultipartFile;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserReadDto toReadDto(User user);

    User toModel(UserReadDto userReadDto);

    UserEditDto toEditDto(User user);

    User toModel(UserEditDto userEditDto);

    User toModel(UserImageDto userImageDto);

    default String map(MultipartFile multipartFile) {
        return multipartFile.getOriginalFilename();
    }

    default void copy(User user, UserEditDto object, PasswordEncoder passwordEncoder) {
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
