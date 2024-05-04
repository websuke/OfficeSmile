package com.example.officesmile.Repository.dto;

public record UserDTO(
        String userId,
        String userName,
        String authId,
        String password,
        String authority,
        String roleName
){
}
