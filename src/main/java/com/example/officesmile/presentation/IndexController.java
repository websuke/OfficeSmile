package com.example.officesmile.presentation;

import com.example.officesmile.domain.common.Util;
import com.example.officesmile.domain.entity.auth.AuthEntity;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index(HttpSession session) {
        var principal = Util.getLoggedInUser(session);

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


}
