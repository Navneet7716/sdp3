package com.example.sdp3.Controller;

import com.example.sdp3.Pojo.Applicant;
import com.example.sdp3.Service.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/applicant")
public class ApplicantController{

    @Autowired
    ApplicantService applicantService;

    @PostMapping("/addapplicant")
    @PreAuthorize("hasRole('USER')")
    public Applicantreturn addNewApplicant(@RequestBody Applicant applicant){
        Applicantreturn response = new Applicantreturn();

        try{
            applicantService.addApplicant(applicant);
            response.message = "Added Successfully";
            response.error = false;
        }
        catch(Exception e){
            e.getMessage();
            response.message = "Failed to add";
            response.error = true;
        }
        return response;
    }

    @GetMapping("/getallapplicants")
    @PreAuthorize("hasRole('USER')")
    public Applicantreturn getApplicant(){
        Applicantreturn response = new Applicantreturn();
        try{
            response.ListData = applicantService.getAllApplicants();
            response.message = "Success";
            response.error = false;
        }
        catch(Exception e){
            e.getMessage();
            response.message="Failed";
            response.error=false;
        }
        return response;
    }

    @GetMapping("/getapplicantbyid/{id}")
    @PreAuthorize("hasRole('USER')")
    public Applicantreturn getApplicantById(@PathVariable Long id){
        Applicantreturn response = new Applicantreturn();
        try{
            response.data = applicantService.findApplicantById(id);
            response.message = "Found the applicant";
            response.error = false;
        }
        catch(Exception e){
            e.getMessage();
            response.message = "Did not find the applicant";
            response.error = true;
        }
        return response;
    }

    @DeleteMapping("/deleteapplicantbyid/{id}")
    @PreAuthorize("hasRole('USER')")
    public Applicantreturn deleteApplicantById(@PathVariable  Long id){
        Applicantreturn response = new Applicantreturn();
        try{
            applicantService.deleteApplicantById(id);
            response.message = "Deleted Successfully";
            response.error = false;
        }
        catch(Exception e){
            e.getMessage();
            response.message = "Failed to delete";
            response.error = true;
        }
        return response;
    }

    @PatchMapping("/updateapplicant")
    @PreAuthorize("hasRole('USER')")
    public Applicantreturn updateApplicant(@RequestBody Applicant updatedapplicant){
        Applicantreturn response = new Applicantreturn();
        try{
            applicantService.updateApplicant(updatedapplicant);
            response.message = "Successfully updated "+ updatedapplicant.getId();
            response.error = false;
        }
        catch(Exception e){
            response.message = e.getMessage();
            response.error = true;
        }
        return response;
    }





}
