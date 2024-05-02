package com.example.officesmile.domain.auth;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Optional;

@Mapper
public interface AuthRepository {

    @Select("SELECT auth_id, password, authority FROM auths WHERE auth_id = #{authId}")
    Optional<Auth> findByAuthId(@Param("authId") String authId);
}

