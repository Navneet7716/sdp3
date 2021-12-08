package com.example.sdp3.Controller;

import com.example.sdp3.Pojo.Posts;

import java.util.List;
import java.util.Optional;

public class Postreturn {
    public String message;
    public List<Posts> data;
    public boolean success;

    public Postreturn(String message, boolean success, List<Posts> data) {
        this.message = message;
        this.data = data;
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Posts> getData() {
        return data;
    }

    public void setData(List<Posts> data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
