package com.example.officesmile.infrastructure.dao;

import com.example.officesmile.domain.entity.auth.AuthEntity;
import com.example.officesmile.infrastructure.dto.UserDTO;
import com.example.officesmile.mapper.auth.AuthMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

/**
 * 権限Dao
 */
@Repository
@RequiredArgsConstructor
public class AuthDao {

    private final AuthMapper authMapper;

    /**
     * 権限IDを基にユーザー検索
     * @param authId
     * @return
     */
    public UserDTO userSearchByAuthId(Long authId) {
        return authMapper.userSearchByAuthId(authId);
    };

    /**
     * 権限登録
     *
     * @param auth
     * @return
     */
    public Long store(AuthEntity auth) {
        return authMapper.store(auth);
    };
}

