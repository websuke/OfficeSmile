package com.example.officesmile.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {
        // 管理者以上の場合

        // 本日既に帰社している場合

        // 本日帰社していない場合
        return "redirect:/returning-to-works";
    }
}
