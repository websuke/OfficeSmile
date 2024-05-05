package com.example.officesmile.presentation;

import com.example.officesmile.domain.common.Util;
import com.example.officesmile.domain.entity.auth.AuthEntity;
import com.example.officesmile.domain.useCase.adminOrAbove.ReturningToWorkAndHomeNewStatusGetUseCase;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class IndexController {

    private final ReturningToWorkAndHomeNewStatusGetUseCase returningToWorkAndHomeNewStatusGetUseCase;

    @GetMapping("/")
    public String index(HttpSession session) {
        var principal = Util.getLoggedInUser(session);

        // 管理者以上の場合、xxへリダイレクト
        if (principal.getAuthorities().equals(AuthEntity.Authority.SUPER_USER) || principal.getAuthorities().equals(AuthEntity.Authority.ADMIN)) {
            return "redirect:/sitemap";
        }

        // 本日の帰社・帰宅最新状況を取得
        var newReturningToWorkAndHome = returningToWorkAndHomeNewStatusGetUseCase
                .getReturningToWorkAndHomeNewStatus(
                        Long.parseLong(principal.getUserId()
                )
        );

        // 帰社していない もしくは 一度帰社したが帰宅登録も既に一度行われている場合、帰社登録画面へリダイレクト
        if (newReturningToWorkAndHome == null || newReturningToWorkAndHome.goingHomeId() != null) {

            return "redirect:/returning-to-works";
        }

        // 上記以外の場合、帰宅登録画面へリダイレクト
        return "redirect:/going-home";
    }
}
