package com.example.officesmile.domain.entity.userRole;

public record UserRoleEntity (
  Long userId,
  Long roleId
) {

    public static UserRoleEntity toEntity(Long userId, String roleId) {
        return new UserRoleEntity(
                userId,
                Long.parseLong(roleId)
        );
    }
}
