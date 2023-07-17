package kz.aidyninho.jobcy.dto;

public record CategoryDto(Long id,
                          String name,
                          String icon,
                          Integer jobsCount) {
}
