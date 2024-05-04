package com.example.officesmile.infrastructure.dao;

import com.example.officesmile.domain.entity.userRole.UserRoleEntity;
import com.example.officesmile.mapper.userRole.UserRoleMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserRoleDao {

    private final UserRoleMapper userRoleMapper;

    public void store(UserRoleEntity userRole) {
        userRoleMapper.store(userRole);
    };
}
