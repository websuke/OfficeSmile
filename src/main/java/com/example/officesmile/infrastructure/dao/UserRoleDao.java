package com.example.officesmile.infrastructure.dao;

import com.example.officesmile.domain.entity.userRole.UserRoleEntity;
import com.example.officesmile.mapper.userRole.UserRoleMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

/**
 * ユーザー×ロールDao
 */
@Repository
@RequiredArgsConstructor
public class UserRoleDao {

    private final UserRoleMapper userRoleMapper;

    /**
     * ユーザー×ロール登録
     * @param userRole
     */
    public void store(UserRoleEntity userRole) {
        userRoleMapper.store(userRole);
    };
}
