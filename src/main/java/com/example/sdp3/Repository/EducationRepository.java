package com.example.sdp3.Repository;

import com.example.sdp3.Pojo.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationRepository extends JpaRepository<Education,Long> {

}
