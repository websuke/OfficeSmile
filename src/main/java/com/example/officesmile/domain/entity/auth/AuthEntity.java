package com.example.officesmile.domain.entity.auth;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 権限エンティティ
 */
@Data
@AllArgsConstructor
public class AuthEntity {
    private String authId;
    private String password;
    private Authority authority;
    private Long userId;

    public static AuthEntity toEntity(String authId, String password, String authority, Long userId) {
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

        /**
         * 和名
         */
        private final String name;

        private Authority(String name) {
            this.name = name;
        }

        /**
         * 和名取得
         *
         * @return
         */
        public String getName() {
            return this.name;
        }
    }
}

