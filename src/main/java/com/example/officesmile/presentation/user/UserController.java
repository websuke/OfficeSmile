package com.example.officesmile.presentation.user;

import com.example.officesmile.domain.useCase.adminOrAbove.AuthPullDownGetUseCase;
import com.example.officesmile.domain.useCase.adminOrAbove.RolePullDownGetUseCase;
import com.example.officesmile.domain.useCase.adminOrAbove.UserStoreUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserStoreUseCase userStoreUseCase;
    private final RolePullDownGetUseCase rolePullDownGetUseCase;
    private final AuthPullDownGetUseCase authPullDownGetUseCase;

    @GetMapping("/signup")
    public String showSignUpForm(Model model) {
        model.addAttribute("rolePullDown", rolePullDownGetUseCase.invoke());
        model.addAttribute("authPullDown", authPullDownGetUseCase.invoke());

        return "/user/signup";
    }

    @PostMapping
    public String store(UserForm form) {

        userStoreUseCase.invoke(form.userName(), form.authId(), form.password(), form.authority(), form.roleId());

        return "redirect:/";
    }
}
