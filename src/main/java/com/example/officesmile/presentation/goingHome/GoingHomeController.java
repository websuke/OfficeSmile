package com.example.officesmile.presentation.goingHome;

import com.example.officesmile.config.MultiMessageSource;
import com.example.officesmile.domain.common.Util;
import com.example.officesmile.domain.useCase.adminOrAbove.ReturningToWorkAndHomeNewStatusGetUseCase;
import com.example.officesmile.domain.useCase.general.GoingHomeStoreUseCase;
import com.example.officesmile.presentation.auth.LogoutController;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * 帰宅コントローラー
 */
@Controller
@RequestMapping("/going-homes")
@RequiredArgsConstructor
public class GoingHomeController {

    private final LogoutController logoutController;

    private final ReturningToWorkAndHomeNewStatusGetUseCase returningToWorkAndHomeNewStatusGetUseCase;

    private final GoingHomeStoreUseCase goingHomeStoreUseCase;

    private final MultiMessageSource messageSource;

    /**
     * 帰宅登録画面初期表示
     *
     * @param session
     * @param model
     * @param redirectAttributes
     * @return
     */
    @GetMapping
    public String index(HttpSession session, Model model, RedirectAttributes redirectAttributes) {
        // 本日の帰社・帰宅最新状況を取得
        var newReturningToWorkAndHome = returningToWorkAndHomeNewStatusGetUseCase
                .getReturningToWorkAndHomeNewStatus(
                            Long.parseLong(Util.getLoggedInUser(session).getUserId()
                        )
                );

        // 帰社していない もしくは 一度帰社したが紐づく帰宅登録も既に行われている場合、帰社登録画面へリダイレクト
        if (newReturningToWorkAndHome == null || newReturningToWorkAndHome.goingHomeId() != null) {

            var test = messageSource.getMessage("must_return_to_work");

            redirectAttributes.addFlashAttribute("message", messageSource.getMessage("must_return_to_work"));

            return "redirect:/returning-to-works";
        }

        model.addAttribute("returningToWorkTime", newReturningToWorkAndHome.returningToWorkDateTime());

        return "going-home/index";
    }

    /**
     * 帰宅登録処理
     *
     * @param session
     * @param request
     * @param response
     * @return
     */
    @PostMapping
    public String store(HttpSession session, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
        var principal = Util.getLoggedInUser(session);

        // 本日の帰社・帰宅最新状況を取得
        var newReturningToWorkAndHome = returningToWorkAndHomeNewStatusGetUseCase
                .getReturningToWorkAndHomeNewStatus(
                        Long.parseLong(principal.getUserId()
                        )
                );

        goingHomeStoreUseCase.store(Long.parseLong(newReturningToWorkAndHome.returningToWorkId()));

        return logoutController.logout(request, response, redirectAttributes);
    }
}
