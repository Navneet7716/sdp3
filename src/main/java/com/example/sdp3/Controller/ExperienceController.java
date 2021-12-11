package com.example.sdp3.Controller;


import com.example.sdp3.Pojo.Experience;
import com.example.sdp3.Service.ExperienceService;
import com.example.sdp3.payload.response.ExperienceResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(value = "*" , maxAge = 3600)
@RestController
@RequestMapping("/api/experience")
public class ExperienceController {


    final
    ExperienceService experienceService;


    public ExperienceController(ExperienceService experienceService) {
        this.experienceService = experienceService;
    }

    @GetMapping("/getByUserId/{id}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<ExperienceResponse> getByUserId(@PathVariable Long id) {

       ExperienceResponse experienceResponse = new ExperienceResponse();

        try {
        List<Experience> data = experienceService.getExperienceByUser_id(id);
        experienceResponse.message="Successfully Retrieved";
        experienceResponse.error=false;
        experienceResponse.Listdata = data;

            return ResponseEntity.ok(experienceResponse);
       }catch (Exception e) {

            experienceResponse.message = e.getMessage();
            experienceResponse.error=true;
            return ResponseEntity.status(400).body(experienceResponse);

        }

    }

    @GetMapping("/getById/{id}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<ExperienceResponse> getById(@PathVariable Long id) {

        ExperienceResponse experienceResponse = new ExperienceResponse();

        try {
            Experience data = experienceService.getExperienceById(id);
            experienceResponse.message="Successfully Retrieved";
            experienceResponse.error=false;
            experienceResponse.data = data;

            return ResponseEntity.ok(experienceResponse);
        }catch (Exception e) {

            experienceResponse.message = e.getMessage();
            experienceResponse.error=true;
            return ResponseEntity.status(400).body(experienceResponse);

        }

    }


    @PatchMapping("/updateById")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<ExperienceResponse> updateById(@RequestBody Experience experience) {
        ExperienceResponse experienceResponse = new ExperienceResponse();
        try {

            experienceService.updateExperience(experience);

            experienceResponse.error=false;
            experienceResponse.message="Updated Successfully";
            experienceResponse.data = null;

            return ResponseEntity.status(201).body(experienceResponse);
        }
        catch (Exception e) {
            experienceResponse.message = e.getMessage();
            experienceResponse.error=true;
            return ResponseEntity.status(400).body(experienceResponse);
        }

    }


    @PostMapping("/addExperience")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<ExperienceResponse> addExperience(@RequestBody Experience experience) {
        ExperienceResponse experienceResponse = new ExperienceResponse();
        try {
            experienceService.CreateExperience(experience);
            experienceResponse.error=false;
            experienceResponse.message="Created Successfully";
            experienceResponse.data = null;

            return ResponseEntity.status(201).body(experienceResponse);
        }catch (Exception e) {

            experienceResponse.message = e.getMessage();
            experienceResponse.error=true;
            return ResponseEntity.status(400).body(experienceResponse);

        }
    }

    @DeleteMapping("/deletebyid/{id}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<ExperienceResponse> deleteExperience(@PathVariable Long id) {
        ExperienceResponse experienceResponse = new ExperienceResponse();
        try {
            experienceService.deleteExperienceById(id);
            experienceResponse.error=false;
            experienceResponse.message="Deleted Successfully";
            return ResponseEntity.status(200).body(experienceResponse);
        }
        catch (Exception e) {
            experienceResponse.message = e.getMessage();
            experienceResponse.error=true;
            return ResponseEntity.status(400).body(experienceResponse);
        }
    }





}
