package kz.aidyninho.jobcy.entity;

import org.springframework.security.core.GrantedAuthority;

public enum UserRole implements GrantedAuthority {
    USER,
    COMPANY,
    ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}
