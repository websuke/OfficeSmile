package com.example.officesmile.mapper.user;

import com.example.officesmile.domain.entity.user.UserEntity;

public interface UserMapper {

    void store(UserEntity user);

    Long getMaxUserId();
}
