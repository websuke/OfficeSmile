package com.example.officesmile.presentation.auth;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    /**
     * ログイン画面表示
     *
     * @return
     */
    @GetMapping("/login")
    public String showLogin() {
        return "auth/login";
    }
}
