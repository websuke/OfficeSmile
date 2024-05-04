package com.example.officesmile.Repository.dao;

import com.example.officesmile.domain.entity.auth.AuthEntity;
import com.example.officesmile.mapper.auth.AuthMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class AuthDao {

    private final AuthMapper authMapper;

    public AuthEntity findByAuthId(String authId) {
        return authMapper.findByAuthId(authId);
    };

    public Long store(AuthEntity auth) {
        return authMapper.store(auth);
    };
}

