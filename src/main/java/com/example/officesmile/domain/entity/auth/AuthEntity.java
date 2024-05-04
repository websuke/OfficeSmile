package com.example.officesmile.domain.entity.auth;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class AuthEntity {
    private Long authId;
    private String password;
    private Authority authority;
    private Long userId;

    public static AuthEntity toEntity(Long authId, String password, String authority, Long userId) {
        return new AuthEntity(
                authId,
                password,
                Authority.valueOf(authority),
                userId
        );
    }

    public enum Authority {
        GENERAL("一般"),
        ADMIN("管理者"),
        SUPER_USER("スーパーユーザー");

        private final String name;

        private Authority(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }
    }
}
