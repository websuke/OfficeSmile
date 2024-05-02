package com.example.officesmile.domain.auth;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Auth {
    private String authId;
    private String password;
    private Authority authority;

    public enum Authority {
        GENERAL,
        ADMIN,
        SUPER_USER
    }
}
