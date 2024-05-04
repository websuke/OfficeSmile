package com.example.officesmile.domain.common;

import com.example.officesmile.domain.authentication.CustomUserDetailsService;
import jakarta.servlet.http.HttpSession;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Util {

    public static CustomUserDetailsService.CustomUserDetails getLoggedInUser(HttpSession session) {
        return (CustomUserDetailsService.CustomUserDetails) session.getAttribute("loggedInUser");
    }

    public static String now() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
}
