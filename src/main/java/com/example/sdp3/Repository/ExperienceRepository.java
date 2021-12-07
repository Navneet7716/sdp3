package com.example.sdp3.Repository;

import com.example.sdp3.Pojo.Experience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ExperienceRepository extends JpaRepository<Experience, Long> {

    @Query("select e from Experience e where e.user_id= ?1 ")
    Optional<List<Experience>> findExperienceByUser_id(Long user_id);
}
