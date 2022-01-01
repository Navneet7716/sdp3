package com.example.sdp3.Repository;


import com.example.sdp3.Pojo.Education;
import com.example.sdp3.Pojo.Jobs;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JobRepository extends PagingAndSortingRepository<Jobs, Long> {

    Page<Jobs> findAllByUserId(Long id, Pageable pageable);

}
