package com.example.officesmile.domain.entity.user;

public record UserEntity (
        Long userId,
        String userName,
        String authId
) {
    public static UserEntity toEntity(Long userId, String userName, String authId) {
        return new UserEntity(
                userId,
                userName,
                authId
        );
    }

}
