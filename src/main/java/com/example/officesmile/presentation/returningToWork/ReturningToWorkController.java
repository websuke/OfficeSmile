package com.example.officesmile.presentation.returningToWork;

import com.example.officesmile.domain.authentication.CustomUserDetailsService;
import com.example.officesmile.domain.useCase.general.ReturningToWorkStoreUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

/**
 * 帰社コントローラー
 */
@Controller
@RequestMapping("/returning-to-works")
@RequiredArgsConstructor
public class ReturningToWorkController {

    private final ReturningToWorkStoreUseCase returningToWorkStoreUseCase;

    /**
     * 初期表示(帰社登録画面表示)
     *
     * @return
     */
    @GetMapping
    public String index(@ModelAttribute ReturningToWorkForm form, Model model) {

        return "returning-to-work/index";
    }

    @PostMapping
    public String store(@SessionAttribute("loggedInUser") CustomUserDetailsService.CustomUserDetails loggedInUser,
                        @Validated @ModelAttribute ReturningToWorkForm form,
                        BindingResult result,
                        Model model
    ) {
        if (result.hasErrors()) {
            return index(form, model);
        }

        returningToWorkStoreUseCase.invoke(form.reasonSummaryId(), form.reasonDetail(), loggedInUser.getUserId());

        return "redirect:/";
    }
}
