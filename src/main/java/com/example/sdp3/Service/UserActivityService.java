package com.example.sdp3.Service;


import com.example.sdp3.Pojo.Posts;
import com.example.sdp3.Pojo.User;
import com.example.sdp3.Pojo.UserActivity;
import com.example.sdp3.Repository.PostsRepository;
import com.example.sdp3.Repository.UserActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UserActivityService {

    final UserActivityRepository userActivityRepository;

    @Autowired
    PostsRepository postsRepository;


    public UserActivityService(UserActivityRepository userActivityRepository) {
        this.userActivityRepository = userActivityRepository;
    }


    public UserActivity getByUserIDAndPostID(Long user_id, Long post_id) {

        try {
            return userActivityRepository.findAllByUserIdAndPostId(user_id, post_id).orElseThrow(() -> new IllegalStateException("Not Found"));

        }catch(Exception e) {

            throw new IllegalStateException("Data not found");

        }

    }

    public int GetLikeCount(Long post_id) {
            List<UserActivity> us = userActivityRepository.getAllByPostIdAndIsliked(post_id, true);
        return us.size();
    }

    public void createUserActivity(UserActivity userActivity) {

        Optional<UserActivity> userActivity1 = userActivityRepository.findAllByUserIdAndPostId(userActivity.getUserId(), userActivity.getPostId());

        if (userActivity1.isEmpty()){
            userActivityRepository.save(userActivity);
        }else {
            userActivity1.ifPresent((e) -> {
                e.setIsliked(userActivity.getIsliked());
                userActivityRepository.save(e);
            });
        }

        updateLikeCount(userActivity);





    }
    public void updateLikeCount(UserActivity userActivity) {

        if (userActivity.getIsliked()) {
        postsRepository.findById(userActivity.getPostId()).ifPresentOrElse((e) -> {

            Long count = (long) userActivityRepository.getLikeCount(e.getId()).size();

            e.setLike_count(count);

            postsRepository.save(e);


        }, () -> {
            System.out.println("WOW THIS IS NICE!!");
        });

        }
        else {
            postsRepository.findById(userActivity.getPostId()).ifPresentOrElse((e) -> {
                long count =  e.getLike_count() - 1;
                if (count <0) {
                    count = 0L;
                }

                e.setLike_count(count);

                postsRepository.save(e);

            },() -> {});
        }
    }



}
