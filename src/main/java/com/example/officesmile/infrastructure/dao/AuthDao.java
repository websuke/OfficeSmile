package com.example.officesmile.infrastructure.dao;

import com.example.officesmile.domain.entity.auth.AuthEntity;
import com.example.officesmile.infrastructure.dto.UserDTO;
import com.example.officesmile.mapper.auth.AuthMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class AuthDao {

    private final AuthMapper authMapper;

    public UserDTO userSearchByAuthId(Long authId) {
        return authMapper.userSearchByAuthId(authId);
    };

    public Long store(AuthEntity auth) {
        return authMapper.store(auth);
    };
}

