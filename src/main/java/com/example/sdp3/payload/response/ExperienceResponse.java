package com.example.sdp3.payload.response;

import com.example.sdp3.Pojo.Experience;

import java.util.List;

public class ExperienceResponse {
    
    public String message;
    public boolean error;
    public List<Experience> Listdata;
    public Experience data;

    public ExperienceResponse() {
        this.data = null;
        this.Listdata = null;
    }
    
    
}
