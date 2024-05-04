package com.example.officesmile.domain.useCase.adminOrAbove;

import com.example.officesmile.Repository.dao.AuthDao;
import com.example.officesmile.Repository.dao.UserDao;
import com.example.officesmile.Repository.dao.UserRoleDao;
import com.example.officesmile.domain.entity.auth.AuthEntity;
import com.example.officesmile.domain.entity.user.UserEntity;
import com.example.officesmile.domain.entity.userRole.UserRoleEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserStoreUseCase {

    private final AuthDao authDao;
    private final UserDao userDao;
    private final UserRoleDao userRoleDao;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void invoke(String userName, String authId, String password, String authority, String roleId) {
        var encodedPassword = passwordEncoder.encode(password);

        userDao.store(UserEntity.toEntity(null, userName));

        Long maxUserId = userDao.getMaxUserId();

        authDao.store(AuthEntity.toEntity(authId, encodedPassword, authority, maxUserId.toString()));

        userRoleDao.store(UserRoleEntity.toEntity(maxUserId.toString(), roleId));
    }
}
