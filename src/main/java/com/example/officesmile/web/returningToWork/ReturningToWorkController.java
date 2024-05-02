package com.example.officesmile.web.returningToWork;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String initialDisplay(Model model) {
        model.addAttribute("test", "test");

        return "returning-to-work/form";
    }
}
