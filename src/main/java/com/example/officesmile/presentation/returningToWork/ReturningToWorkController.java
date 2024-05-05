package com.example.officesmile.presentation.returningToWork;

import com.example.officesmile.domain.authentication.CustomUserDetailsService;
import com.example.officesmile.domain.useCase.adminOrAbove.ReturningToWorkAndHomeNewStatusGetUseCase;
import com.example.officesmile.domain.useCase.general.ReturningToWorkStoreUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * 帰社コントローラー
 */
@Controller
@RequestMapping("/returning-to-works")
@RequiredArgsConstructor
public class ReturningToWorkController {

    private final ReturningToWorkStoreUseCase returningToWorkStoreUseCase;
    private final ReturningToWorkAndHomeNewStatusGetUseCase returningToWorkAndHomeNewStatusGetUseCase;

    /**
     * 帰社登録画面初期表示
     *
     * @param loggedInUser ログインユーザー
     * @param form フォーム
     * @param redirectAttributes リダイレクトアトリビュート
     * @return
     */
    @GetMapping
    public String index(@SessionAttribute("loggedInUser") CustomUserDetailsService.CustomUserDetails loggedInUser,
                        @ModelAttribute ReturningToWorkForm form,
                        RedirectAttributes redirectAttributes
    ) {

        // 本日の帰社・帰宅最新状況を取得
        var newReturningToWorkAndHome = returningToWorkAndHomeNewStatusGetUseCase
                .getReturningToWorkAndHomeNewStatus(
                        Long.parseLong(loggedInUser.getUserId()
                        )
                );

        // 帰社している かつ その帰社に紐づく帰宅登録が行われていない場合、帰宅登録画面へリダイレクト
        if (newReturningToWorkAndHome != null && newReturningToWorkAndHome.goingHomeId() == null) {

            redirectAttributes.addFlashAttribute("message", "帰宅登録を実施してからでないと帰社登録は出来ません。");

            return "redirect:/going-homes";
        }

        return "returning-to-work/index";
    }

    /**
     * 帰社登録処理
     *
     * @param loggedInUser ログインユーザー
     * @param form フォーム
     * @param result バリデーション結果
     * @param redirectAttributes リダイレクトアトリビュート(初期表示で使用するため記載しているが本メソッドだけでいうと不要)
     * @return
     */
    @PostMapping
    public String store(@SessionAttribute("loggedInUser") CustomUserDetailsService.CustomUserDetails loggedInUser,
                        @Validated @ModelAttribute ReturningToWorkForm form,
                        BindingResult result,
                        RedirectAttributes redirectAttributes
    ) {
        if (result.hasErrors()) {
            return index(loggedInUser, form, redirectAttributes);
        }

        returningToWorkStoreUseCase.invoke(form.reasonSummaryId(), form.reasonDetail(), loggedInUser.getUserId());

        return "redirect:/";
    }
}
