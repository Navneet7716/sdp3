package com.example.sdp3.Service;


import com.example.sdp3.Repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.sdp3.Pojo.Jobs;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static java.lang.System.out;

@Service
public class JobService{

    @Autowired
    JobRepository jobRepository;

    public void addJob(Jobs newJob){

        Optional<Jobs> job = jobRepository.findById(newJob.getId());

        if (job.isPresent()) {
            throw new IllegalStateException("Job Already Present");
        }

        jobRepository.save(newJob);


    }


    public void deleteJobById(Long id){
        jobRepository.deleteById(id);
    }

    public List<Jobs> getAllJobs(){
        try{
            return (List<Jobs>) jobRepository.findAll();
        }
        catch(Exception e){
            out.println("Jobs not yet inserted");
            return Collections.emptyList();
        }
    }

    public Optional<Jobs> findJobById(Long id){
        return jobRepository.findById(id);
    }


}
