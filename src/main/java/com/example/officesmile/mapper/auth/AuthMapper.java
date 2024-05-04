package com.example.officesmile.mapper.auth;

import com.example.officesmile.Repository.dto.UserDTO;
import com.example.officesmile.domain.entity.auth.AuthEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AuthMapper {

    UserDTO findByAuthId(Long authId);

    Long store(AuthEntity auth);

    UserDTO userSearchByAuthId(Long authId);
}

