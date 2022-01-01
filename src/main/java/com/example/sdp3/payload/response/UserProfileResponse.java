package com.example.sdp3.payload.response;

import com.example.sdp3.Pojo.User;
import com.example.sdp3.Pojo.UserProfile;

import java.util.List;

public class UserProfileResponse {
    private String message;
    private boolean success;
    private List<UserProfile> data;

    public UserProfileResponse(String message , boolean success , List<UserProfile> userProfiles)
    {
        this.message = message;
        this.success = success;
        this.data = userProfiles;
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

    public List<UserProfile> getData() {
        return data;
    }

    public void setData(List<UserProfile> data) {
        this.data = data;
    }
}
