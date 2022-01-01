package com.example.sdp3.Service;

import com.example.sdp3.Pojo.Applicant;
import com.example.sdp3.Pojo.Jobs;
import com.example.sdp3.Repository.ApplicantRepository;
import com.example.sdp3.Repository.JobRepository;
import com.example.sdp3.Repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ApplicantService {
    @Autowired
    ApplicantRepository applicantRepository;

    @Autowired
    JobRepository jobRepository;

    @Autowired
    UserProfileRepository userProfileRepository;



    public Applicant addApplicant(Applicant newapplicant){

//       Optional<Applicant> applicant = applicantRepository.findById(newapplicant.getId());
//
//        if (applicant.isPresent()) {
//            throw new IllegalStateException("Applicant Already Present");
//        }
       return applicantRepository.save(newapplicant);
    }

    public void deleteApplicantById(Long id){
        applicantRepository.deleteById(id);
    }

    public List<Applicant> getAllApplicants(){
        List<Applicant> applicants = applicantRepository.findAll();

        if(applicants.size()!=0){
            return applicants;
        }
        else{
            throw new IllegalStateException("Applicants Don't Exist");
        }
    }

    public Applicant findApplicantById(Long id){
       return applicantRepository.findById(id).orElseThrow(()-> new IllegalStateException("no Applicant"));
    }

    public List<Applicant> findApplicantByJOBId(Long id){
        List<Applicant> applicants = applicantRepository.getApplicantByJob_id(id).orElseThrow(() -> new IllegalStateException("Applicant Not found"));
        applicants.forEach(el -> {
            el.setUserData(userProfileRepository.findAllByUserId(el.getUser_id()));
        });
        applicants.forEach(el -> {
            el.setPostData(jobRepository.findById(el.getJob_id()).get());
        });

        return applicants;
    }
    public List<Applicant> findApplicantByUSERId(Long id){


        List<Applicant> data = applicantRepository.getApplicantByUser_id(id).get();
        data.forEach(el -> {
            Jobs jobs = jobRepository.findById(el.getJob_id()).get();
            el.setPostData(jobs);
        });

        return data;
    }

    public Applicant findApplicantByJOBIDandUSERID(Long job_id, Long user_id) {
        return applicantRepository.getApplicantByJob_idAndAndUser_id(job_id,user_id).orElseThrow(()-> new IllegalStateException("Applicant Not found"));
    }

    @Transactional
    public Applicant updateApplicant(Applicant updateapplicant){
        Optional<Applicant> applicant = applicantRepository.findById(updateapplicant.getId());

        if(applicant.isPresent()){
           return applicantRepository.save(updateapplicant);
        }
        else{
            throw new IllegalStateException("Applicant not found");
        }


    }
}
