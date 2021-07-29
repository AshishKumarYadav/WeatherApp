package com.ashish.transo.Pojo;

public class LocationPojo {

    private String name;

    private String country;

    private String region;

    private String lat;

    private String lon;

    private String timezone_id;

    private String localtime;

    private int localtime_epoch;

    private String utc_offset;

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setCountry(String country){
        this.country = country;
    }
    public String getCountry(){
        return this.country;
    }
    public void setRegion(String region){
        this.region = region;
    }
    public String getRegion(){
        return this.region;
    }
    public void setLat(String lat){
        this.lat = lat;
    }
    public String getLat(){
        return this.lat;
    }
    public void setLon(String lon){
        this.lon = lon;
    }
    public String getLon(){
        return this.lon;
    }
    public void setTimezone_id(String timezone_id){
        this.timezone_id = timezone_id;
    }
    public String getTimezone_id(){
        return this.timezone_id;
    }
    public void setLocaltime(String localtime){
        this.localtime = localtime;
    }
    public String getLocaltime(){
        return this.localtime;
    }
    public void setLocaltime_epoch(int localtime_epoch){
        this.localtime_epoch = localtime_epoch;
    }
    public int getLocaltime_epoch(){
        return this.localtime_epoch;
    }
    public void setUtc_offset(String utc_offset){
        this.utc_offset = utc_offset;
    }
    public String getUtc_offset(){
        return this.utc_offset;
    }
}
