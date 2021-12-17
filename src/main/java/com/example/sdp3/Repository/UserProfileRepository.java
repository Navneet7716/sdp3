package com.example.sdp3.Repository;


import com.example.sdp3.Pojo.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {

    UserProfile findAllByUserId(Long user_id);

}
