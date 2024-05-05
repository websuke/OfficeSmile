package com.example.officesmile.presentation.user;

import com.example.officesmile.domain.useCase.adminOrAbove.AuthPullDownGetUseCase;
import com.example.officesmile.domain.useCase.adminOrAbove.RolePullDownGetUseCase;
import com.example.officesmile.domain.useCase.adminOrAbove.UserStoreUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ユーザーコントローラー
 */
@Controller
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserStoreUseCase userStoreUseCase;
    private final RolePullDownGetUseCase rolePullDownGetUseCase;
    private final AuthPullDownGetUseCase authPullDownGetUseCase;

    /**
     * ユーザー作成画面表示
     *
     * @param form
     * @param model
     * @return
     */
    @GetMapping("/signup")
    public String showSignUpForm(@ModelAttribute UserForm form, Model model) {
        model.addAttribute("rolePullDown", rolePullDownGetUseCase.invoke());
        model.addAttribute("authPullDown", authPullDownGetUseCase.invoke());

        return "/user/signup";
    }

    /**
     * ユーザー作成処理
     *
     * @param form
     * @param result
     * @param model
     * @return
     */
    @PostMapping
    public String store(@Validated @ModelAttribute UserForm form, BindingResult result, Model model) {
        if (result.hasErrors()) {

            return showSignUpForm(form, model);
        }

        userStoreUseCase.invoke(form.userName(), form.authId(), form.password(), form.authority(), form.roleId());

        return "redirect:/";
    }
}
