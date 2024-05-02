package com.example.officesmile.domain.auth;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class CustomUserDetails extends User {

//    private final String userId;

    public CustomUserDetails(String authId, String password, Collection<? extends GrantedAuthority> authorities) {
        super(authId, password, authorities);
//        this.userId = userId;
    }
}
