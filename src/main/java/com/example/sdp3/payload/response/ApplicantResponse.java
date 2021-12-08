package com.example.sdp3.Controller;

import com.example.sdp3.Pojo.Applicant;

import java.util.List;
import java.util.Optional;

public class Applicantreturn {
    public String message;
    public List<Applicant> data;
    public boolean success;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Applicant> getData() {
        return data;
    }

    public void setData(List<Applicant> data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Applicantreturn(String message, boolean success, List<Applicant> data) {
        this.message = message;
        this.data = data;
        this.success = success;
    }
}
