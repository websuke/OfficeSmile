package com.example.officesmile.presentation;

import com.example.officesmile.domain.authentication.CustomUserDetailsService;
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
        if (getAuthority(principal).equals(AuthEntity.Authority.ADMIN.name()) || getAuthority(principal).equals(AuthEntity.Authority.SUPER_USER.name())) {
            return "redirect:/users/signup";
        }

        // 本日の帰社・帰宅最新状況を取得
        var newReturningToWorkAndHome = returningToWorkAndHomeNewStatusGetUseCase
                .getReturningToWorkAndHomeNewStatus(
                        Long.parseLong(principal.getUserId()
                )
        );

        // 帰社していない もしくは 一度帰社したが紐づく帰宅登録も既に行われている場合、帰社登録画面へリダイレクト
        if (newReturningToWorkAndHome == null || newReturningToWorkAndHome.goingHomeId() != null) {

            return "redirect:/returning-to-works";
        }

        // 上記以外の場合、帰宅登録画面へリダイレクト
        return "redirect:/going-homes";
    }

    /**
     * 権限取得
     *
     * @param principal
     * @return
     */
    private String getAuthority(CustomUserDetailsService.CustomUserDetails principal) {

        return principal.getAuthorities().toArray()[0].toString();
    }
}
