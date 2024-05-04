package com.example.officesmile.mapper.auth;

import com.example.officesmile.domain.entity.auth.AuthEntity;
import com.example.officesmile.infrastructure.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AuthMapper {

    UserDTO findByAuthId(Long authId);

    Long store(AuthEntity auth);

    UserDTO userSearchByAuthId(Long authId);
}

