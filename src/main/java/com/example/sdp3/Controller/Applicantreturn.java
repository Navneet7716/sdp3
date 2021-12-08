package com.example.sdp3.Controller;

import com.example.sdp3.Pojo.Applicant;

import java.util.List;
import java.util.Optional;

public class Applicantreturn {
    public String message;
    public boolean error;

    public Applicant data;
    public List<Applicant> ListData;


    Applicantreturn(){
        this.data = null;
        this.ListData = null;
    }
}
