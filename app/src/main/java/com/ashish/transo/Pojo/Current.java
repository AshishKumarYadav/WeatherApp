package com.ashish.transo.Pojo;

import java.util.List;

public class Current {
    private String observation_time;

    private int temperature;

    private int weather_code;

    private List<String> weather_icons;

    private List<String> weather_descriptions;

    private int wind_speed;

    private int wind_degree;

    private String wind_dir;

    private int pressure;

    private double precip;

    private int humidity;

    private int cloudcover;

    private int feelslike;

    private int uv_index;

    private int visibility;

    private String is_day;

    public void setObservation_time(String observation_time){
        this.observation_time = observation_time;
    }
    public String getObservation_time(){
        return this.observation_time;
    }
    public void setTemperature(int temperature){
        this.temperature = temperature;
    }
    public int getTemperature(){
        return this.temperature;
    }
    public void setWeather_code(int weather_code){
        this.weather_code = weather_code;
    }
    public int getWeather_code(){
        return this.weather_code;
    }
    public void setWeather_icons(List<String> weather_icons){
        this.weather_icons = weather_icons;
    }
    public List<String> getWeather_icons(){
        return this.weather_icons;
    }
    public void setWeather_descriptions(List<String> weather_descriptions){
        this.weather_descriptions = weather_descriptions;
    }
    public List<String> getWeather_descriptions(){
        return this.weather_descriptions;
    }
    public void setWind_speed(int wind_speed){
        this.wind_speed = wind_speed;
    }
    public int getWind_speed(){
        return this.wind_speed;
    }
    public void setWind_degree(int wind_degree){
        this.wind_degree = wind_degree;
    }
    public int getWind_degree(){
        return this.wind_degree;
    }
    public void setWind_dir(String wind_dir){
        this.wind_dir = wind_dir;
    }
    public String getWind_dir(){
        return this.wind_dir;
    }
    public void setPressure(int pressure){
        this.pressure = pressure;
    }
    public int getPressure(){
        return this.pressure;
    }
    public void setPrecip(double precip){
        this.precip = precip;
    }
    public double getPrecip(){
        return this.precip;
    }
    public void setHumidity(int humidity){
        this.humidity = humidity;
    }
    public int getHumidity(){
        return this.humidity;
    }
    public void setCloudcover(int cloudcover){
        this.cloudcover = cloudcover;
    }
    public int getCloudcover(){
        return this.cloudcover;
    }
    public void setFeelslike(int feelslike){
        this.feelslike = feelslike;
    }
    public int getFeelslike(){
        return this.feelslike;
    }
    public void setUv_index(int uv_index){
        this.uv_index = uv_index;
    }
    public int getUv_index(){
        return this.uv_index;
    }
    public void setVisibility(int visibility){
        this.visibility = visibility;
    }
    public int getVisibility(){
        return this.visibility;
    }
    public void setIs_day(String is_day){
        this.is_day = is_day;
    }
    public String getIs_day(){
        return this.is_day;
    }
}
