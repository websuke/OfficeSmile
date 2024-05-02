package com.example.officesmile.web.user;

public record UserForm (
        String authId,
        String password,
        String userName,
        String authority,
        String role
){

}
