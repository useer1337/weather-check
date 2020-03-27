package com.project.weather.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String greeting(Model model) {
        model.addAttribute("title", "Главная страница");
        model.addAttribute("hello","Hello world");
        return "main";
    }

    @GetMapping("/signUp")
    public String signUp(Model model){
        return "signUp";
    }

    @GetMapping("/aboutMe")
    public String aboutMe(Model model){
        return "aboutMe";
    }
}