package com.example.sdp3.Controller;


import com.example.sdp3.Pojo.Jobs;
import com.example.sdp3.Repository.JobRepository;
import com.example.sdp3.Service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static java.lang.System.out;

@RestController
public class JobsController{
    @Autowired
    JobService jobService;

    @PostMapping("/")
    public Jobreturn addJobPost(@RequestBody Jobs job){
        Jobreturn response = new Jobreturn();
        try{
            jobService.addJob(job);
            response.message="added successfully";
            response.error=false;
        }
        catch(Exception e){
            response.message=e.getMessage();
            response.error=true;
        }
        return response;
    }

    @GetMapping("/getall")
    public Jobreturn getAll(){
        Jobreturn response = new Jobreturn();
        try{
            List<Jobs> job = jobService.getAllJobs();
            response.message="Success";
            response.error=false;
            response.ListData = job;
        }
        catch(Exception e){
            response.message="failed";
            response.error=true;
            response.ListData=null;
        }
        return response;
    }

    @GetMapping("/getbyid/{id}")
    public Jobreturn getJobById(@PathVariable Long id){
        Jobreturn response = new Jobreturn();
        try{
            Optional<Jobs> job = jobService.findJobById(id);
            response.message = "Success";
            response.error= false;
            response.data=job;

        }
        catch (Exception e){
            response.message = "Failed";
            response.error= true;
            response.data=null;
        }

        return response;
    }

    @DeleteMapping("/deletebyid/{id}")
    public Jobreturn deleteJobById(@PathVariable Long id){
        Jobreturn response = new Jobreturn();
        try {
            jobService.deleteJobById(id);

            response.message = "Deleted Successfully " + id;
            response.error = false;
        }
        catch(Exception e){
            response.message="Deletion Unsuccessfull "+id;
            response.error=true;
        }
        response.data=null;
        return response;
    }


    @PatchMapping("/update")
    public Jobreturn updateJob(@RequestBody Jobs job){
        Jobreturn response = new Jobreturn();
        try{
            jobService.updateJobs(job);
            response.message="Job Updated";
            response.error=false;
        }
        catch (Exception e){
            response.message=e.getMessage();
            response.error=true;
        }
        return response;
    }
}
