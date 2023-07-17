package kz.aidyninho.jobcy.dto;

public record JobsUsersReadForUserDto(JobDto job,
                                      Long userId,
                                      String message) {
}
