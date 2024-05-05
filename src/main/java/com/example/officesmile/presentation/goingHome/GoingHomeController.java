package com.example.officesmile.presentation.goingHome;

import com.example.officesmile.domain.common.Util;
import com.example.officesmile.domain.useCase.adminOrAbove.ReturningToWorkAndHomeNewStatusGetUseCase;
import com.example.officesmile.domain.useCase.general.GoingHomeStoreUseCase;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/going-homes")
@RequiredArgsConstructor
public class GoingHomeController {

    private final ReturningToWorkAndHomeNewStatusGetUseCase returningToWorkAndHomeNewStatusGetUseCase;
    private final GoingHomeStoreUseCase goingHomeStoreUseCase;

    @GetMapping
    public String index() {

        return "going-home/index";
    }

    @PostMapping
    public String store(HttpSession session) {
        var principal = Util.getLoggedInUser(session);

        // 本日の帰社・帰宅最新状況を取得
        var newReturningToWorkAndHome = returningToWorkAndHomeNewStatusGetUseCase
                .getReturningToWorkAndHomeNewStatus(
                        Long.parseLong(principal.getUserId()
                        )
                );

        goingHomeStoreUseCase.store(Long.parseLong(newReturningToWorkAndHome.returningToWorkId()));

        return "redirect:/";
    }
}
