package com.example.sdp3.Service;

import com.example.sdp3.Pojo.Applicant;
import com.example.sdp3.Repository.ApplicantRepository;
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

    public void addApplicant(Applicant newapplicant){

//       Optional<Applicant> applicant = applicantRepository.findById(newapplicant.getId());
//
//        if (applicant.isPresent()) {
//            throw new IllegalStateException("Applicant Already Present");
//        }
        applicantRepository.save(newapplicant);
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

    public Optional<Applicant> findApplicantById(Long id){
        Optional<Applicant> applicant = applicantRepository.findById(id);
        if(applicant.isPresent()){
            return applicant;
        }
        else{
            throw new IllegalStateException("Applicant Does not Exist");
        }
    }

    @Transactional
    public void updateApplicant(Applicant updateapplicant){
        Optional<Applicant> applicant = applicantRepository.findById(updateapplicant.getId());

        if(applicant.isPresent()){
            applicantRepository.save(updateapplicant);
        }
        else{
            throw new IllegalStateException("Applicant not found");
        }

    }
}
