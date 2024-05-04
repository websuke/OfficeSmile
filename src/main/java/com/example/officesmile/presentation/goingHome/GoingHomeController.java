package com.example.officesmile.presentation.goingHome;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/going-home")
public class GoingHomeController {

    @GetMapping
    public String index() {

        return "going-home/index";
    }
}