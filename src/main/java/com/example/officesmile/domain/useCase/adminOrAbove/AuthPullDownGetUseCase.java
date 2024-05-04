package com.example.officesmile.domain.useCase.adminOrAbove;

import com.example.officesmile.domain.entity.auth.AuthEntity;
import com.example.officesmile.infrastructure.dao.AuthDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AuthPullDownGetUseCase {
    private final AuthDao authDao;

    @Transactional
    public Map<String, String> invoke() {

        Map<String, String> authPullDown = new HashMap<>();

        for (AuthEntity.Authority enumItem : AuthEntity.Authority.values()) {
            authPullDown.put(enumItem.name(), enumItem.getName());
        }

        return authPullDown;
    }
}
