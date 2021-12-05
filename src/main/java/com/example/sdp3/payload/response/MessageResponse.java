package com.example.sdp3.payload.response;


import com.example.sdp3.Pojo.User;

import java.util.List;

public class MessageResponse {
    private String message;
    private boolean success;
    private List<User> data;

    public boolean isSuccess() {
        return success;
    }

    public List<User> getData() {
        return data;
    }

    public void setData(List<User> data) {
        this.data = data;
    }

    public boolean getSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public MessageResponse(String message,boolean success,List<User> data) {
        this.message = message;
        this.success = success;
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
