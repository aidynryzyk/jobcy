package kz.aidyninho.jobcy.dto;

import kz.aidyninho.jobcy.entity.User;

public record JobsUsersReadDto(Long jobId,
                               User user,
                               String message) {
}
