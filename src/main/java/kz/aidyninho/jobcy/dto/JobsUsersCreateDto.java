package kz.aidyninho.jobcy.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class JobsUsersCreateDto {

    private Long jobId;
    private Long userId;
    private String message;
}
