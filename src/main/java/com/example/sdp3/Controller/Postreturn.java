package com.example.sdp3.Controller;

import com.example.sdp3.Pojo.Posts;

import java.util.List;
import java.util.Optional;

public class Postreturn {
    public String message;
    public Optional<Posts> data;

    public List<Posts> ListData;

    public boolean error;

    public Postreturn(){
        data = null;
        ListData = null;
    }
}
