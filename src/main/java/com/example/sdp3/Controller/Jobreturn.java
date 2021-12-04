package com.example.sdp3.Controller;

import com.example.sdp3.Pojo.Jobs;

import java.util.List;
import java.util.Optional;

public class Jobreturn {

    public String message;

    public Optional<Jobs> data;

    public List<Jobs> ListData;

    public boolean error;


    Jobreturn() {
        this.data = null;
        this.ListData = null;
    }



}
