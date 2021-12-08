package com.example.sdp3.Controller;

import com.example.sdp3.Pojo.Jobs;

import java.util.List;
import java.util.Optional;

public class Jobreturn {
    public String message;
    public List<Jobs> data;
    public boolean success;

    public Jobreturn(String message, boolean success, List<Jobs> data) {
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

    public List<Jobs> getData() {
        return data;
    }

    public void setData(List<Jobs> data) {
        this.data = data;
    }

    public boolean isError() {
        return success;
    }

    public void setError(boolean success) {
        this.success = success;
    }
}
