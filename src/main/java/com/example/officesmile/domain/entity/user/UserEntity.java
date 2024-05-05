package com.example.officesmile.domain.entity.user;

/**
 * ユーザーエンティティ
 *
 * @param userId
 * @param userName
 */
public record UserEntity (
        Long userId,
        String userName
) {
    public static UserEntity toEntity(Long userId, String userName) {
        return new UserEntity(
                userId,
                userName
        );
    }

}
