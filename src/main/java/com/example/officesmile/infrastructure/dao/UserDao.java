package com.example.officesmile.infrastructure.dao;

import com.example.officesmile.domain.entity.user.UserEntity;
import com.example.officesmile.mapper.user.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

/**
 * ユーザーDao
 */
@Repository
@RequiredArgsConstructor
public class UserDao {

    private final UserMapper userMapper;

    /**
     * ユーザー登録
     *
     * @param user
     */
    public void store(UserEntity user) {
        userMapper.store(user);
    };

    /**
     * ユーザーID最大値検索
     *
     * @return
     */
    public Long getMaxUserId() {
        return userMapper.getMaxUserId();
    };
}
