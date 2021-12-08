package com.example.sdp3.payload.response;

import com.example.sdp3.Pojo.UserActivity;

import java.util.List;

public class ActivityResponse extends Response{
    public UserActivity data;
    public List<UserActivity> listData;
    public int dataint;

    public ActivityResponse() {}
}
