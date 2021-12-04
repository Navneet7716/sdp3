package com.example.sdp3.Repository;


import com.example.sdp3.Pojo.Jobs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<Jobs, Long> {
}
