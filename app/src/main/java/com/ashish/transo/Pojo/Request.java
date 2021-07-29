package com.ashish.transo.Pojo;

public class Request {

    private String type;

    private String query;

    private String language;

    private String unit;

    public void setType(String type){
        this.type = type;
    }
    public String getType(){
        return this.type;
    }
    public void setQuery(String query){
        this.query = query;
    }
    public String getQuery(){
        return this.query;
    }
    public void setLanguage(String language){
        this.language = language;
    }
    public String getLanguage(){
        return this.language;
    }
    public void setUnit(String unit){
        this.unit = unit;
    }
    public String getUnit(){
        return this.unit;
    }
}
