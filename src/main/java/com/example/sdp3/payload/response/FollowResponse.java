package com.example.sdp3.payload.response;

import com.example.sdp3.Pojo.Follow;

import java.util.List;

public class FollowResponse extends Response{

    public int follows_count;
    public List<Follow> Follower_ListData;
    public int follower_count;
    public List<Follow> Follow_ListData;

    public FollowResponse() {}
}
