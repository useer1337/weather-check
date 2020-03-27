package com.project.weather.controllers;

import com.project.weather.models.WeatherModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@Controller
public class WeatherController {
    @GetMapping("/weather")
    public String weather(Model model) throws IOException {
        WeatherModel weatherModel = new WeatherModel();

        model.addAttribute("title", "Погода");
        model.addAttribute("kurganWeather",weatherModel.getWeather());
        model.addAttribute("weatherImage", weatherModel.getImage());
        System.out.println(weatherModel.getWeather());
        return "weather";
    }
}
