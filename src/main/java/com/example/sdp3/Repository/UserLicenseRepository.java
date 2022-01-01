package com.example.sdp3.Repository;

import com.example.sdp3.Pojo.Experience;
import com.example.sdp3.Pojo.UserLicense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserLicenseRepository extends JpaRepository<UserLicense , Long> {

    @Query("select e from UserLicense e where e.user_id= ?1 ")
    Optional<List<UserLicense>> findUserLicenseByUser_id(Long user_id);
}
