package com.example.sdp3.Repository;


import com.example.sdp3.Pojo.Projects;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProjectsRepository extends JpaRepository<Projects, Long> {

    @Query("select p from Projects p where p.user_id=?1")
    Optional<List<Projects>> getAllByUser_id(Long id);

}
