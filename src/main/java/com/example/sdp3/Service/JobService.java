package com.example.sdp3.Service;


import com.example.sdp3.Pojo.Applicant;
import com.example.sdp3.Pojo.Posts;
import com.example.sdp3.Repository.ApplicantRepository;
import com.example.sdp3.Repository.JobRepository;
import com.example.sdp3.Repository.UserProfileRepository;
import com.example.sdp3.Security.services.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import com.example.sdp3.Pojo.Jobs;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class JobService{

    @Autowired
    JobRepository jobRepository;

    @Autowired
    UserProfileRepository userProfileRepository;

    @Autowired
    ApplicantRepository applicantRepository;

    public Jobs addJob(Jobs newJob){
        return jobRepository.save(newJob);
    }

    public void deleteJobById(Long id){
        jobRepository.deleteById(id);
    }

    public Page<Jobs> getAllJobs(Integer pageNo, Integer pageSize, String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).descending());

        Page<Jobs> pagedResults =  jobRepository.findAll(paging);

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Long userid = ((UserDetailsImpl) principal).getId();

        pagedResults.getContent().forEach((el) -> {

            el.setUserData(userProfileRepository.findAllByUserId(el.getUser_id()));

            Optional<Applicant> applicant = applicantRepository.getApplicantByJob_idAndAndUser_id(el.getId(),userid);
            if(applicant.isPresent()) {
                el.setApplied(true);
            }

        });

//        pagedResults.getContent().stream().filter(el -> !Objects.equals(el.getUser_id(), userid)).toList().forEach(el -> System.out.println(el.getId()));

        return pagedResults;
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
        public Jobs updateJobs(Jobs updateJob){
            Optional<Jobs> job = jobRepository.findById(updateJob.getId());

            if(job.isPresent()){
                return jobRepository.save(updateJob);
            }
            else{
                throw new IllegalStateException("Job not found");
            }

        }
    }
