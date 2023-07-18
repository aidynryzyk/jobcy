package kz.aidyninho.jobcy.dto;

import kz.aidyninho.jobcy.entity.UserRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class UserReadDto {

    private Long id;
    private String username;
    private String password;
    private String email;
    private UserRole role;
    private List<JobReadWithoutUserDto> jobs;
    private String fullName;
    private String description;
    private String phone;
    private String whatsapp;
    private String instagram;
    private String image;

}
