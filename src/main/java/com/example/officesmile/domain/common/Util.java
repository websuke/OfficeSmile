package com.example.officesmile.domain.common;

import com.example.officesmile.domain.auth.CustomUserDetailsService;
import jakarta.servlet.http.HttpSession;

public class Util {

    public static CustomUserDetailsService.CustomUserDetails getLoggedInUser(HttpSession session) {
        return (CustomUserDetailsService.CustomUserDetails) session.getAttribute("loggedInUser");
    }
}
