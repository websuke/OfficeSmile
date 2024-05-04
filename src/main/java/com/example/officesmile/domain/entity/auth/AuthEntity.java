package com.example.officesmile.domain.entity.auth;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class AuthEntity {
    private Long authId;
    private String password;
    private Authority authority;
    private Long userId;

    public static AuthEntity toEntity(Long authId, String password, String authority, Long userId) {
        return new AuthEntity(
                authId,
                password,
                Authority.valueOf(authority),
                userId
        );
    }

    public enum Authority {
        GENERAL,
        ADMIN,
        SUPER_USER
    }
}
