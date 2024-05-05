package com.example.officesmile.infrastructure.dto;

/**
 * ユーザーDTO
 *
 * @param userId
 * @param userName
 * @param authId
 * @param password
 * @param authority
 * @param roleName
 */
public record UserDTO(
        String userId,
        String userName,
        String authId,
        String password,
        String authority,
        String roleName
){
}
