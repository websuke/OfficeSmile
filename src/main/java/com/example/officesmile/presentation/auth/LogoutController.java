package com.example.officesmile.presentation.auth;

import com.example.officesmile.config.MultiMessageSource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * ログアウトコントローラー
 */
@Controller
@RequiredArgsConstructor
public class LogoutController {

    private final MultiMessageSource messageSource;

    /**
     * ログアウト処理
     *
     * @param request
     * @param response
     * @return
     */
    @PostMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
        new SecurityContextLogoutHandler().logout(request, response, SecurityContextHolder.getContext().getAuthentication());

        redirectAttributes.addFlashAttribute("message", messageSource.getMessage("thanks_message"));

        return "redirect:/login?logout";
    }
}
