package com.example.sdp3.Service;


import com.example.sdp3.Pojo.Education;
import com.example.sdp3.Repository.EducationRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EducationService {


    final EducationRepository educationRepository;

    public EducationService(EducationRepository educationRepository) {
        this.educationRepository = educationRepository;
    }


    // get by user id

    public List<Education> getByUserId(Long id){

        return educationRepository.findAllByUser_id(id).orElseThrow(() -> new IllegalStateException("No Items found."));

    }


    // get by id

    public Education getbyid(Long id) {
        return educationRepository.findById(id).orElseThrow(() -> new IllegalStateException("Education leda"));
    }


    // delete by id

    public void deletebyid(Long id) {
        boolean b = educationRepository.existsById(id);

        if (!b) {
            throw new IllegalStateException("record doesn't exists");
        }

        educationRepository.deleteById(id);
    }



    // update by id
    @Transactional
    public Education update(Education education) {

        Education education1 = educationRepository.findById(education.getId()).orElseThrow(() -> new IllegalStateException("Education doesn't exist"));

        if (education.getInstitution_name().length() > 0  && education.getLocation().length() > 0) {

            return educationRepository.save(education);

        }
        else {
            throw new IllegalStateException("Unexpected data");
        }

    }



    // create



    public Education create(Education education) {
        try {

           return educationRepository.save(education);

        }
        catch (Exception e) {
            throw new IllegalStateException("Couldn't create record");
        }

    }




}
