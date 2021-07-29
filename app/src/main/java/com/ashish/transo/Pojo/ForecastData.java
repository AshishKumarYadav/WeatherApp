package com.ashish.transo.Pojo;

public class ForecastData {

    private String date;

    private int date_epoch;

    private Astro astro;

    private int mintemp;

    private int maxtemp;

    private int avgtemp;

    private int totalsnow;

    private double sunhour;

    private int uv_index;

    public void setDate(String date){
        this.date = date;
    }
    public String getDate(){
        return this.date;
    }
    public void setDate_epoch(int date_epoch){
        this.date_epoch = date_epoch;
    }
    public int getDate_epoch(){
        return this.date_epoch;
    }
    public void setAstro(Astro astro){
        this.astro = astro;
    }
    public Astro getAstro(){
        return this.astro;
    }
    public void setMintemp(int mintemp){
        this.mintemp = mintemp;
    }
    public int getMintemp(){
        return this.mintemp;
    }
    public void setMaxtemp(int maxtemp){
        this.maxtemp = maxtemp;
    }
    public int getMaxtemp(){
        return this.maxtemp;
    }
    public void setAvgtemp(int avgtemp){
        this.avgtemp = avgtemp;
    }
    public int getAvgtemp(){
        return this.avgtemp;
    }
    public void setTotalsnow(int totalsnow){
        this.totalsnow = totalsnow;
    }
    public int getTotalsnow(){
        return this.totalsnow;
    }
    public void setSunhour(double sunhour){
        this.sunhour = sunhour;
    }
    public double getSunhour(){
        return this.sunhour;
    }
    public void setUv_index(int uv_index){
        this.uv_index = uv_index;
    }
    public int getUv_index(){
        return this.uv_index;
    }
}
