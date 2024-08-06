package com.tokendogg.comment_system.entity;

public class CustomJSONResponse {

    private String message;

    public CustomJSONResponse(String message) {
        this.message = message;
    }

    // Getters and setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
