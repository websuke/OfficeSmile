package com.example.officesmile.controller.returningToWork;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 帰社コントローラー
 */
@Controller
@RequestMapping("/returning-to-works")
public class ReturningToWorkController {

    /**
     * 初期表示
     *
     * @return
     */
    @GetMapping
    public String initialDisplay() {

        return "returning-to-work/form.html";
    }
}
