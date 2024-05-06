package com.example.officesmile.presentation.auth;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * ログアウトコントローラー
 */
@Controller
public class LogoutController {

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

        redirectAttributes.addFlashAttribute("message", "お疲れ様でした。<br>\n" +
                "                またのお越しをお待ちしています。<br>\n" +
                "                お気をつけてお帰り下さい。");

        return "redirect:/login?logout";
    }
}
