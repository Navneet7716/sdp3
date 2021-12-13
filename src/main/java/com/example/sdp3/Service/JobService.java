package com.example.sdp3.Service;


import com.example.sdp3.Pojo.Posts;
import com.example.sdp3.Repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.example.sdp3.Pojo.Jobs;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JobService{

    @Autowired
    JobRepository jobRepository;

    public void addJob(Jobs newJob){
        jobRepository.save(newJob);
    }

    public void deleteJobById(Long id){
        jobRepository.deleteById(id);
    }

    public Page<Jobs> getAllJobs(Integer pageNo, Integer pageSize, String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).descending());

        return jobRepository.findAll(paging);
//
//        if(pagedResult.hasContent()) {
//            return pagedResult.getContent();
//        } else {
//            return new ArrayList<Jobs>();
//        }
    }

        public Optional<Jobs> findJobById (Long id){
            Optional<Jobs> job = jobRepository.findById(id);
            if (job.isPresent()) {
                return job;
            } else {
                throw new IllegalStateException("Job Does not Exist");
            }
        }

    public Page<Jobs> findJobByUserId (Integer pageNo, Integer pageSize, String sortBy,Long id){
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).descending());

        return jobRepository.findAllByUserId(id,paging);
//        if(pagedResult.hasContent()) {
//            return pagedResult.getContent();
//        } else {
//            return new ArrayList<Jobs>();
//        }
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
