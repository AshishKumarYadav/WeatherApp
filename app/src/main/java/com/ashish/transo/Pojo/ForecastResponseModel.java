package com.ashish.transo.Pojo;

public class ForecastResponseModel {

    private Request request;

    private Location location;

    private Current current;

    private Forecast forecast;

    private boolean success;

    private Error error;

    public void setSuccess(boolean success){
        this.success = success;
    }
    public boolean getSuccess(){
        return this.success;
    }
    public void setError(Error error){
        this.error = error;
    }
    public Error getError(){
        return this.error;
    }
    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Current getCurrent() {
        return current;
    }

    public void setCurrent(Current current) {
        this.current = current;
    }

    public Forecast getForecast() {
        return forecast;
    }

    public void setForecast(Forecast forecast) {
        this.forecast = forecast;
    }
}
