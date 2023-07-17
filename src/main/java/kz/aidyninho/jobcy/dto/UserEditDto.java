package kz.aidyninho.jobcy.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class UserEditDto {

    private Long id;
    private String email;
    private String fullName;
    private String description;
    private String phone;
    private String whatsapp;
    private String instagram;
    private String rawPassword;
    private String newPassword;

}
