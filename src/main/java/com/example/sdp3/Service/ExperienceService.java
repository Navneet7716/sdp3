package com.example.sdp3.Service;


import com.example.sdp3.Pojo.Experience;
import com.example.sdp3.Repository.ExperienceRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ExperienceService {

    final
    ExperienceRepository experienceRepository;

    public ExperienceService(ExperienceRepository experienceRepository) {
        this.experienceRepository = experienceRepository;
    }

    public Experience getExperienceById(Long id) {

        return experienceRepository.findById(id).orElseThrow(() -> new IllegalStateException("Experience Not found"));

    }

    public Experience CreateExperience(Experience experience) {
        return experienceRepository.save(experience);
    }

    public List<Experience> getExperienceByUser_id(Long id)  {

        return experienceRepository.findExperienceByUser_id(id).orElseThrow(() -> new IllegalStateException("No Items are present"));


    }

    @Transactional
    public Experience updateExperience(Experience UpdatedExperience) {
        Experience experience = experienceRepository.findById(UpdatedExperience.getId()).orElseThrow(() -> new IllegalStateException("Experience Not found"));

        if (UpdatedExperience.getTitle().length() > 0 && UpdatedExperience.getLocation().length() > 0 && UpdatedExperience.getDescription().length() > 0) {
            experience.setTitle(UpdatedExperience.getTitle());
            experience.setDuration(UpdatedExperience.getDuration());
            experience.setLocation(UpdatedExperience.getLocation());
            experience.setDescription(UpdatedExperience.getDescription());
        }

        return experience;

    }

    public void deleteExperienceById(Long id) {

        boolean b = experienceRepository.existsById(id);
        if (!b) {
            throw new IllegalStateException("Experince with id " + id + " does not exists");
        }

        experienceRepository.deleteById(id);
    }



}
