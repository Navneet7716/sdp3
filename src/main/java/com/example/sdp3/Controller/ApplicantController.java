package com.example.sdp3.Controller;

import com.example.sdp3.Pojo.Applicant;
import com.example.sdp3.Service.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(value = "*",maxAge = 3600)
@RestController
@RequestMapping("/api/applicant")
public class ApplicantController{

    //this is cross

    final
    ApplicantService applicantService;

    public ApplicantController(ApplicantService applicantService) {
        this.applicantService = applicantService;
    }

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

            response.message =  e.getMessage();
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

            response.message= e.getMessage();
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

            response.message =  e.getMessage();
            response.error = true;
        }
        return response;
    }

    @GetMapping("/getapplicantbyjobid/{id}")
    @PreAuthorize("hasRole('USER')")
    public Applicantreturn getApplicantByJOBId(@PathVariable Long id){
        Applicantreturn response = new Applicantreturn();
        try{
            response.ListData = applicantService.findApplicantByJOBId(id);
            response.message = "Found the applicant";
            response.error = false;
        }
        catch(Exception e){

            response.message =  e.getMessage();
            response.error = true;
        }
        return response;
    }

    @GetMapping("/getapplicantbyuserid/{id}")
    @PreAuthorize("hasRole('USER')")
    public Applicantreturn getApplicantByUserId(@PathVariable Long id){
        Applicantreturn response = new Applicantreturn();
        try{
            response.ListData = applicantService.findApplicantByUSERId(id);
            response.message = "Found the applicant";
            response.error = false;
        }
        catch(Exception e){

            response.message =  e.getMessage();
            response.error = true;
        }
        return response;
    }

    @GetMapping("/getapplicantbyuseridandjobid/{job_id}/{user_id}")
    @PreAuthorize("hasRole('USER')")
    public Applicantreturn getApplicantByUserandJobId(@PathVariable Long job_id, @PathVariable Long user_id){
        Applicantreturn response = new Applicantreturn();
        try{
            response.data = applicantService.findApplicantByJOBIDandUSERID(job_id,user_id);
            response.message = "Found the applicant";
            response.error = false;
        }
        catch(Exception e){

            response.message =  e.getMessage();
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

            response.message = e.getMessage();
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
