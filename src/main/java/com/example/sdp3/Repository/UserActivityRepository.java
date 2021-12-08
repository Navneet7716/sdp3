package com.example.sdp3.Repository;


import com.example.sdp3.Pojo.UserActivity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserActivityRepository extends JpaRepository<UserActivity, Long> {

    @Query("select a from UserActivity a where a.user_id=?1 and a.post_id=?2")
    Optional<UserActivity> findByUser_idAndPost_id(Long user_id, Long post_id);

    @Query("select count(a) from UserActivity a where a.post_id=?1 and a.is_liked=true ")
    Optional<Integer> getLikeCount(Long post_id);
}
