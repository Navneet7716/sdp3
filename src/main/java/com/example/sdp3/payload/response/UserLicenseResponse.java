package com.example.sdp3.payload.response;

import com.example.sdp3.Pojo.UserLicense;
import com.example.sdp3.Pojo.UserProfile;


import java.util.List;

public class UserLicenseResponse {

    private String message;
    private boolean success;
    private List<UserLicense> data;

    public UserLicenseResponse(String message , boolean success , List<UserLicense> userLicenses)
    {
        this.message = message;
        this.success = success;
        this.data = userLicenses;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<UserLicense> getData() {
        return data;
    }

    public void setData(List<UserLicense> data) {
        this.data = data;
    }
}
