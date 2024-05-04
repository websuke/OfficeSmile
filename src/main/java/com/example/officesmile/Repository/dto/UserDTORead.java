package com.example.officesmile.Repository.dto;

public record UserDTORead(
        String userId,
        String userName,
        String authId,
        String password,
        String authority,
        String role
){
}
