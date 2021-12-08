package com.example.sdp3.Repository;

import com.example.sdp3.Pojo.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EducationRepository extends JpaRepository<Education,Long> {

    @Query("select e from Education e where e.user_id=?1 ")
    Optional<List<Education>> findAllByUser_id(Long id);

}
