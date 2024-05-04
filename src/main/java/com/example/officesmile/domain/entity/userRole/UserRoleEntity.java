package com.example.officesmile.domain.entity.userRole;

public record UserRoleEntity (
  String userId,
  String roleId
) {

    public static UserRoleEntity toEntity(String userId, String roleId) {
        return new UserRoleEntity(
                userId,
                roleId
        );
    }
}
