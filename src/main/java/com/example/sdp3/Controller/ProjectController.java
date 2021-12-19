package com.example.sdp3.Controller;


import com.example.sdp3.Pojo.Projects;
import com.example.sdp3.Service.ProjectService;
import com.example.sdp3.payload.response.ProjectResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(value = "*",maxAge = 3600)
@RestController
@RequestMapping("/api/project")
public class ProjectController {

    final ProjectService projectService;

    ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/getbyuserid/{id}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<ProjectResponse> getbyuserid(@PathVariable Long id) {

        ProjectResponse projectResponse = new ProjectResponse();

        try {

            projectResponse.ListData = projectService.getallbyuserid(id);

            projectResponse.message = "success";
            projectResponse.error= false;

            return ResponseEntity.ok(projectResponse);

        }
        catch (Exception e) {

            projectResponse.error = true;
            projectResponse.message = e.getMessage();

            return ResponseEntity.status(400).body(projectResponse);
        }


    }

    @PostMapping("/add")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<ProjectResponse> createProject(@RequestBody Projects projects) {
        ProjectResponse projectResponse = new ProjectResponse();
        try {
           projectResponse.Data = projectService.create(projects);
            projectResponse.message = "success";
            projectResponse.error = false;
            return ResponseEntity.status(201).body(projectResponse);

        }
        catch (Exception e) {

            projectResponse.error = true;
            projectResponse.message = e.getMessage();

            return ResponseEntity.status(400).body(projectResponse);
        }
    }


    @GetMapping("/getbyid/{id}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<ProjectResponse> getbyID(@PathVariable Long id) {

        ProjectResponse projectResponse = new ProjectResponse();

        try {

            projectResponse.Data = projectService.getbyid(id);
            projectResponse.message = "success";
            projectResponse.error= false;


            return ResponseEntity.ok(projectResponse);

        }
        catch (Exception e) {

            projectResponse.error = true;
            projectResponse.message = e.getMessage();

            return ResponseEntity.status(400).body(projectResponse);
        }


    }


    @DeleteMapping("/deletebyid/{id}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<ProjectResponse> deleteByID(@PathVariable Long id) {

        ProjectResponse projectResponse = new ProjectResponse();

        try {

            projectService.deletebyid(id);
            projectResponse.message="Deleted Successfully";
            projectResponse.error=false;

            return ResponseEntity.status(200).body(projectResponse);

        }
        catch(Exception e) {
            projectResponse.error = true;
            projectResponse.message = e.getMessage();

            return ResponseEntity.status(400).body(projectResponse);
        }

    }

    @PatchMapping("/update")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<ProjectResponse> updateProject(@RequestBody Projects projects) {
        ProjectResponse projectResponse = new ProjectResponse();

        try {
           projectResponse.Data = projectService.update(projects);

            projectResponse.error = false;
            projectResponse.message = "Updated Successfully";
            return ResponseEntity.status(201).body(projectResponse);
        }
        catch (Exception e) {

            projectResponse.error = true;
            projectResponse.message = e.getMessage();

            return ResponseEntity.status(400).body(projectResponse);

        }
    }


}
