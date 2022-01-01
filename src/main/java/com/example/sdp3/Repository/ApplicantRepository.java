package com.example.sdp3.Repository;

import com.example.sdp3.Pojo.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ApplicantRepository extends JpaRepository<Applicant, Long> {

    @Query("select a from Applicant a where a.user_id=?1")
    Optional<List<Applicant>> getApplicantByUser_id(Long user_id);

    @Query("select a from Applicant a where a.job_id=?1")
    Optional<List<Applicant>> getApplicantByJob_id(Long job_id);

    @Query("select a from Applicant a where a.job_id=?1 and a.user_id=?2")
    Optional<Applicant> getApplicantByJob_idAndAndUser_id(Long job_id, Long user_id);
}
