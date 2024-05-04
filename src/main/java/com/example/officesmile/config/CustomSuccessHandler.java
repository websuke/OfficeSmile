package com.example.officesmile.config;

import com.example.officesmile.domain.auth.CustomUserDetailsService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CustomSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest req, HttpServletResponse res, Authentication auth) throws IOException, ServletException {
        // ログインユーザー情報をsessionに登録
        req.getSession().setAttribute("loggedInUser", getPrincipal());

        // ログイン後のリダイレクト先のURLを設定
        String targetUrl = "/";

        // リダイレクト
        res.sendRedirect(req.getContextPath() + targetUrl);
    }

    /**
     * ログインユーザーの主要情報取得
     *
     * @return
     */
    private CustomUserDetailsService.CustomUserDetails getPrincipal() {
        return (CustomUserDetailsService.CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}