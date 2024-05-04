package com.example.officesmile.domain.entity.user;

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
