package com.example.officesmile.domain.entity.auth;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class AuthEntity {
    private String authId;
    private String password;
    private Authority authority;

    public static AuthEntity toEntity(String authId, String password, String authority) {
        return new AuthEntity(
                authId,
                password,
                Authority.valueOf(authority)
        );
    }

    public enum Authority {
        GENERAL,
        ADMIN,
        SUPER_USER
    }
}
