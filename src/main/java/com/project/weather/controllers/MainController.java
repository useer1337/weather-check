package com.project.weather.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/main")
    public String greeting(Model model) {
        model.addAttribute("title", "Главная страница");
        model.addAttribute("hello","Тут наверно что то должно быть!!");
        return "mainLogined";
    }

    @GetMapping("/aboutMe")
    public String aboutMe(Model model){
        return "aboutMe";
    }

}