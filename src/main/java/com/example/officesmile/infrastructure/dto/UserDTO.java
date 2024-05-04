package com.example.officesmile.infrastructure.dto;

public record UserDTO(
        String userId,
        String userName,
        String authId,
        String password,
        String authority,
        String roleName
){
}
