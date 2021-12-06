package com.example.sdp3.Repository;

import com.example.sdp3.Pojo.UserLicense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserLicenseRepository extends JpaRepository<UserLicense , Long> {
}
