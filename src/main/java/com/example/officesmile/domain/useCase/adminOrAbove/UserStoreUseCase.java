package com.example.officesmile.domain.useCase.adminOrAbove;

import com.example.officesmile.domain.entity.auth.AuthEntity;
import com.example.officesmile.domain.entity.user.UserEntity;
import com.example.officesmile.domain.entity.userRole.UserRoleEntity;
import com.example.officesmile.mapper.auth.AuthMapper;
import com.example.officesmile.mapper.user.UserMapper;
import com.example.officesmile.mapper.userRole.UserRoleMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserStoreUseCase {
    private final AuthMapper authMapper;
    private final UserMapper userMapper;
    private final UserRoleMapper userRoleMapper;

    @Transactional
    public void invoke(String userName, String authId, String password, String authority, String roleId) {
        authMapper.store(AuthEntity.toEntity(authId, password, authority));

        userMapper.store(UserEntity.toEntity(null, userName, authId));

        Long maxUserId = userMapper.getMaxUserId();

        userRoleMapper.store(UserRoleEntity.toEntity(maxUserId, roleId));
    }
}
