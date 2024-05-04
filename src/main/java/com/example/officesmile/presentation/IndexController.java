package com.example.officesmile.presentation;

import com.example.officesmile.domain.auth.CustomUserDetailsService;
import com.example.officesmile.domain.entity.auth.AuthEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {
        var principal = getPrincipal();

        // 管理者以上の場合
        if (principal.getAuthorities().equals(AuthEntity.Authority.SUPER_USER) || principal.getAuthorities().equals(AuthEntity.Authority.ADMIN)) {
            return "redirect:/sitemap";
        }

        // 本日の帰社状況を取得

        // 本日帰社していない または 帰社しているがそれに紐づく帰宅登録がされている場合
        return "redirect:/returning-to-works";

        // 上記以外の場合
//        return 帰宅登録初期表示のメソッド
    }

    /**
     * ログインユーザーの主要情報取得
     *
     * @return
     */
    private CustomUserDetailsService.CustomUserDetails getPrincipal() {
        return (CustomUserDetailsService.CustomUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
