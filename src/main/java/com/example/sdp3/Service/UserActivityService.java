package com.example.sdp3.Service;


import com.example.sdp3.Pojo.UserActivity;
import com.example.sdp3.Repository.UserActivityRepository;
import org.springframework.stereotype.Service;

@Service
public class UserActivityService {

    final UserActivityRepository userActivityRepository;


    public UserActivityService(UserActivityRepository userActivityRepository) {
        this.userActivityRepository = userActivityRepository;
    }


    public UserActivity getByUserIDAndPostID(Long user_id, Long post_id) {
        return userActivityRepository.findByUser_idAndPost_id(user_id, post_id).orElseThrow(() -> new IllegalStateException("Activity Doesn't exists"));
    }

    public int GetLikeCount(Long post_id) {
        return userActivityRepository.getLikeCount(post_id).orElseThrow(()-> new IllegalStateException("Couldn't fetch Like"));
    }

    public void createUserActivity(UserActivity userActivity) {
        userActivityRepository.save(userActivity);
    }



}
