package com.example.officesmile.presentation.returningToWork;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 帰社コントローラー
 */
@Controller
@RequestMapping("/returning-to-works")
public class ReturningToWorkController {

    /**
     * 初期表示(帰社登録画面表示)
     *
     * @return
     */
    @GetMapping
    public String index(Model model) {
        model.addAttribute("test", "test");

        return "returning-to-work/index";
    }

    @PostMapping
    public String store(@ModelAttribute ReturningToWorkForm form) {


        return "redirect:/going-home";
    }
}
