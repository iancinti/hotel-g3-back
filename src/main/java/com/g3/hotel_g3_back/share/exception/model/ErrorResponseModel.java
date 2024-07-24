package com.g3.hotel_g3_back.share.exception.model;

public class ErrorResponseModel {

    private String message;

    public ErrorResponseModel(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}
