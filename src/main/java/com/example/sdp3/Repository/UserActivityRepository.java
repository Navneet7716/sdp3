package com.example.sdp3.Repository;


import com.example.sdp3.Pojo.UserActivity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserActivityRepository extends JpaRepository<UserActivity, Long> {

    Optional<UserActivity> findAllByUserIdAndPostId(Long user_id, Long post_id);

    @Query("select a from UserActivity a where a.postId=?1 and a.isliked=true")
    List<UserActivity> getLikeCount(Long post_id);


    List<UserActivity> getAllByPostIdAndIsliked(Long postId, boolean isLiked);
}
