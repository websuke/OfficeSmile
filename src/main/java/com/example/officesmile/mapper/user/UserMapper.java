package com.example.officesmile.mapper.user;

import com.example.officesmile.domain.entity.user.UserEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    void store(UserEntity user);

    Long getMaxUserId();
}
