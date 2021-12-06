package com.example.sdp3.Repository;


import com.example.sdp3.Pojo.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {

}
