package com.example.officesmile.domain.entity.userRole;

/**
 * ユーザー×ロールエンティティ
 * @param userId
 * @param roleId
 */
public record UserRoleEntity (
  Long userId,
  Long roleId
) {

    public static UserRoleEntity toEntity(Long userId, Long roleId) {
        return new UserRoleEntity(
                userId,
                roleId
        );
    }
}
