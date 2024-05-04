package com.example.officesmile.presentation.user;

public record UserForm (
        String authId,
        String password,
        String userName,
        String authority,
        String role
){

}
