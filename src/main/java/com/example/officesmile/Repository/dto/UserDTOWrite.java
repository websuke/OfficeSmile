package com.example.officesmile.Repository.dto;

public record UserDTOWrite(
        String userId,
        String userName,
        String authId
){
    public UserDTOWrite toDTO(String userId, String userName, String authId) {
        return new UserDTOWrite(userId, userName, authId);
    }
}
