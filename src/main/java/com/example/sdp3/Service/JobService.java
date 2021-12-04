package com.example.sdp3.Service;


import com.example.sdp3.Repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.sdp3.Pojo.Jobs;

import javax.transaction.Transactional;
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
        Optional<Jobs> job = jobRepository.findById(id);
        if(job.isPresent()){
            return job;
        }
        else{
            throw new IllegalStateException("Job Does not Exist");
        }
    }

    @Transactional
    public void updateJobs(Jobs updateJob){
        Optional<Jobs> job = jobRepository.findById(updateJob.getId());

        if(job.isPresent()){
            jobRepository.save(updateJob);
        }
        else{
            throw new IllegalStateException("Job not found");
        }

    }

}
