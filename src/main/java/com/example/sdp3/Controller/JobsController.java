package com.example.sdp3.Controller;


import com.example.sdp3.Pojo.Jobs;
import com.example.sdp3.Service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/job")
public class JobsController{
    @Autowired
    JobService jobService;

    @PostMapping("/addjob")
    @PreAuthorize("hasRole('USER')")
    public Jobreturn addJobPost(@RequestBody Jobs job) {
        Jobreturn response = new Jobreturn();
        try {
            jobService.addJob(job);
            response.message = "Added Successfully";
            response.error = false;
        }
        catch(Exception e){

            response.message = e.getMessage();
            response.error = true;
        }
        return response;
    }

    @GetMapping("/getalljobs")
    @PreAuthorize("hasRole('USER')")
    public Jobreturn getAllJobs(){
        Jobreturn response = new Jobreturn();
        try{
            List<Jobs> job = jobService.getAllJobs();
            response.message="Success";
            response.error=false;
            response.ListData = job;
        }
        catch(Exception e){
            response.message=e.getMessage();
            response.error=true;
            response.ListData=null;
        }
        return response;
    }

    @GetMapping("/getjobsbyid/{id}")
    public Jobreturn getJobById(@PathVariable Long id){
        Jobreturn response = new Jobreturn();
        try{
            Optional<Jobs> job = jobService.findJobById(id);
            response.message = "Success";
            response.error= false;
            response.data=job;

        }
        catch (Exception e){
            response.message = e.getMessage();
            response.error= true;
            response.data=null;
        }

        return response;
    }

    @GetMapping("/getjobsbyuserid/{id}")
    public Jobreturn getjobsbyuserid(@PathVariable Long id){
        Jobreturn response = new Jobreturn();
        try{
            List<Jobs> job = jobService.findJobByUserId(id);
            response.message = "Success";
            response.error= false;
            response.ListData=job;

        }
        catch (Exception e){
            response.message = e.getMessage();
            response.error= true;
            response.data=null;
        }

        return response;
    }

    @DeleteMapping("/deletejobsbyid/{id}")
    public Jobreturn deleteJobById(@PathVariable Long id){
        Jobreturn response = new Jobreturn();
        try {
            jobService.deleteJobById(id);

            response.message = "Deleted Successfully " + id;
            response.error = false;
        }
        catch(Exception e){

            response.message=e.getMessage()+ " " +id;
            response.error=true;
        }
        response.data=null;
        return response;
    }


    @PatchMapping("/updatejobs")
    public Jobreturn updateJob(@RequestBody Jobs job){
        Jobreturn response = new Jobreturn();
        try{
            jobService.updateJobs(job);
            response.message="Job Updated "+job.getId();
            response.error=false;
        }
        catch (Exception e){
            response.message=e.getMessage();
            response.error=true;
        }
        return response;
    }
}
