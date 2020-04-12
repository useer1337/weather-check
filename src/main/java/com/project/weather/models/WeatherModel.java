package com.project.weather.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.project.weather.models.forJson.WeatherJson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherModel {
    private  WeatherJson weatherJson;

    public double getWeather() throws IOException {
        URL url = new URL("https://api.openweathermap.org/data/2.5/weather?q=Kurgan&units=metric&appid=999251b176fa327c51ebee3b8f7f5d2d");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        GsonBuilder builder = new GsonBuilder();
        Gson g = builder.create();
        weatherJson = g.fromJson(response.toString(), WeatherJson.class);

        return weatherJson.main.getTemp();
    }

    public String getImage(){
        if(weatherJson.main.getTemp() <= -20.0){
            return "\\images\\coldVery.gif";
        }

        else if(weatherJson.main.getTemp() > -20.0 && weatherJson.main.getTemp() <= -10.0){
            return "\\images\\coldNorm.gif";
        }

        else if(weatherJson.main.getTemp() > -10.0 && weatherJson.main.getTemp() <= 0.0){
            return "\\images\\coldLow.gif";
        }

        else if(weatherJson.main.getTemp() > 0.0 && weatherJson.main.getTemp() <= 10.0){
            return "\\images\\warmLow.gif";
        }

        else if(weatherJson.main.getTemp() > 10.0 && weatherJson.main.getTemp() <= 20.0){
            return "\\images\\warmNorm.gif";
        }

        else{
            return "\\images\\warmVery.gif";
        }
    }
}
