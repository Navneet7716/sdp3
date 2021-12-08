package com.example.sdp3.Repository;


import com.example.sdp3.Pojo.Education;
import com.example.sdp3.Pojo.Jobs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JobRepository extends JpaRepository<Jobs, Long> {

    @Query("select s from Jobs s where s.user_id=?1")
    Optional<List<Jobs>> findAllByUser_id(Long id);
}
