package com.example.officesmile.web;

import com.example.officesmile.domain.entity.auth.AuthEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {
        var auth = getAuth();

        // 管理者以上の場合
        if (auth.equals(AuthEntity.Authority.SUPER_USER) || auth.equals(AuthEntity.Authority.ADMIN)) {
            return "redirect:/sitemap";
        }

        // 本日の帰社状況を取得

        // 本日帰社していない または 帰社しているがそれに紐づく帰宅登録がされている場合
        return "redirect:/returning-to-works";

        // 上記以外の場合
//        return 帰宅登録初期表示のメソッド
    }

    private String getAuth() {
        return SecurityContextHolder.getContext().getAuthentication().getAuthorities().stream().toList().get(0).toString();
    }
}
