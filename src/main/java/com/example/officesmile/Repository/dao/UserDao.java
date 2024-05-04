package com.example.officesmile.Repository.dao;

import com.example.officesmile.domain.entity.user.UserEntity;
import com.example.officesmile.mapper.user.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserDao {

    private final UserMapper userMapper;

    public void store(UserEntity user) {
        userMapper.store(user);
    };

    public Long getMaxUserId() {
        return userMapper.getMaxUserId();
    };
}
