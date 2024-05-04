package com.example.officesmile.mapper.auth;

import com.example.officesmile.domain.entity.auth.AuthEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AuthMapper {

    AuthEntity findByAuthId(String authId);

    Long store(AuthEntity auth);
}

