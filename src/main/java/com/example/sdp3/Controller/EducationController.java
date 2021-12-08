package com.example.sdp3.Controller;


import com.example.sdp3.Pojo.Education;
import com.example.sdp3.Service.EducationService;
import com.example.sdp3.payload.response.EducationResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/education/")
public class EducationController {

    final EducationService educationService;

    EducationController(EducationService educationService) {
        this.educationService = educationService;
    }

    @GetMapping("/getbyuserid/{id}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<EducationResponse> getbyuserid(@PathVariable Long id) {
        EducationResponse educationResponse = new EducationResponse();

        try {
            educationResponse.ListData = educationService.getByUserId(id);

            educationResponse.message = "success";
            educationResponse.error= false;

            return ResponseEntity.ok(educationResponse);


        }
        catch(Exception e) {
            educationResponse.error = true;
            educationResponse.message = e.getMessage();

            return ResponseEntity.status(400).body(educationResponse);
        }
    }

    @GetMapping("/getbyid/{id}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<EducationResponse> getbyid(@PathVariable Long id) {
        EducationResponse educationResponse = new EducationResponse();

        try {
            educationResponse.Data = educationService.getbyid(id);

            educationResponse.message = "success";
            educationResponse.error= false;

            return ResponseEntity.ok(educationResponse);


        }
        catch(Exception e) {
            educationResponse.error = true;
            educationResponse.message = e.getMessage();

            return ResponseEntity.status(400).body(educationResponse);
        }
    }

    @PostMapping("/add")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<EducationResponse> createEducation(@RequestBody Education education) {
        EducationResponse educationResponse = new EducationResponse();
        try {
            educationService.create(education);
            educationResponse.message = "success";
            educationResponse.error = false;
            return ResponseEntity.status(201).body(educationResponse);

        }
        catch (Exception e) {

            educationResponse.error = true;
            educationResponse.message = e.getMessage();

            return ResponseEntity.status(400).body(educationResponse);
        }
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<EducationResponse> deletebyid(@PathVariable Long id) {

        EducationResponse educationResponse = new EducationResponse();

        try {

            educationService.deletebyid(id);
            educationResponse.message="success";
            educationResponse.error=false;

            return ResponseEntity.status(200).body(educationResponse);
        }
        catch(Exception e) {
            educationResponse.error = true;
            educationResponse.message = e.getMessage();

            return ResponseEntity.status(400).body(educationResponse);
        }

    }


    @PatchMapping("/update")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<EducationResponse> updateEducation(@RequestBody Education education) {
        EducationResponse educationResponse = new EducationResponse();

        try {
            educationService.update(education);

            educationResponse.error = false;
            educationResponse.message = "Updates Successfully";
            return ResponseEntity.status(200).body(educationResponse);
        }catch (Exception e) {
            educationResponse.error = true;
            educationResponse.message= e.getMessage();

            return ResponseEntity.status(400).body(educationResponse);
        }
    }








}
