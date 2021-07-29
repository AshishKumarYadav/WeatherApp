package com.ashish.transo.Pojo;

public class ResponseModel {

    private Request request;

    private LocationPojo location;

    private Current current;

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

    public void setRequest(Request request){
        this.request = request;
    }
    public Request getRequest(){
        return this.request;
    }
    public void setLocation(LocationPojo location){
        this.location = location;
    }
    public LocationPojo getLocation(){
        return this.location;
    }
    public void setCurrent(Current current){
        this.current = current;
    }
    public Current getCurrent(){
        return this.current;
    }
}
