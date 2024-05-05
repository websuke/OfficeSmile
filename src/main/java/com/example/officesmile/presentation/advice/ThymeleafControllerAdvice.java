package com.example.officesmile.presentation.advice;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * Thymeleaf用ControllerAdvice
 */
@ControllerAdvice
public class ThymeleafControllerAdvice {

    /**
     * カレントURL取得
     *
     * Thymeleafで${requestURI}でカレントURLにアクセス可能となる。
     *
     * @param request
     * @return
     */
    @ModelAttribute("requestURI")
    public String requestURI(HttpServletRequest request) {
        String result = request.getRequestURI();
        return result;
    }
}
