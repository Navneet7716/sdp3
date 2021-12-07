package com.example.sdp3.Service;


import com.example.sdp3.Pojo.Projects;
import com.example.sdp3.Repository.ProjectsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ProjectService {


    final ProjectsRepository projectsRepository;


    ProjectService(ProjectsRepository projectsRepository) {
        this.projectsRepository = projectsRepository;
    }

    // get all by userid


    public List<Projects> getallbyuserid(Long id) {

        return projectsRepository.getAllByUser_id(id).orElseThrow(() -> new IllegalStateException("Couldn't find any projects."));


    }



    // get by id


    public Projects getbyid(Long id) {
        return projectsRepository.findById(id).orElseThrow(()-> new IllegalStateException("Couldn't find project"));
    }




    // delete by id

    public void deletebyid(Long id) {
        boolean b = projectsRepository.existsById(id);

        if (!b) {
            throw new IllegalStateException("Project doesn't exists");
        }

        projectsRepository.deleteById(id);
    }


    // update by id

    public void update(Projects projects) {

        Projects projects1 = projectsRepository.findById(projects.getId()).orElseThrow(() -> new IllegalStateException("Project doesn't exist"));

        if (projects.getName().length() > 0 && Objects.equals(projects.getName(), projects1.getName()) && projects.getDescription().length() > 0) {

            projectsRepository.save(projects);

        }
        else {
            throw new IllegalStateException("Unexpected data");
        }

    }


}
