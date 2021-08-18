package ua.training.kondratenko.cargodelivery.entity;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    GUEST, USER, ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}