package com.kashoo.controller;

import com.kashoo.model.LocationProperty;

public class StandardResponse {
 
    private StatusResponse status;
    private String message;
    private LocationProperty location;

    public StandardResponse(StatusResponse status) {
        this.status = status;
    }
    public StandardResponse(StatusResponse status, String message) {
        this.status = status;
        this.message = message;
    }

    public StandardResponse(StatusResponse status, LocationProperty location) {
        this.status = status;
        this.location = location;
    }

    public StatusResponse getStatus() {
        return status;
    }

    public void setStatus(StatusResponse status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}