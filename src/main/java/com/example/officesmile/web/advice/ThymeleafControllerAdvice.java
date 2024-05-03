package com.example.officesmile.web.advice;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class ThymeleafControllerAdvice {
    @ModelAttribute("requestURI")
    public String requestURI(HttpServletRequest request) {
        String result = request.getRequestURI();
        return result;
    }
}
