package com.example.sdp3.Service;


import com.example.sdp3.Pojo.Follow;
import com.example.sdp3.Pojo.UserProfile;
import com.example.sdp3.Repository.FollowRepository;
import com.example.sdp3.Repository.UserProfileRepository;
import com.example.sdp3.Repository.UserRepository;
import com.example.sdp3.Security.services.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
public class UserProfileService {

    @Autowired
    UserProfileRepository userProfileRepository;
    @Autowired
    UserRepository userRepository;

    @Autowired
    FollowRepository followRepository;

    public UserProfile getUserProfileById(Long id)
    {
        try
        {
            UserProfile userProfile = userProfileRepository.findById(id).get();

            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

            Long userid = ((UserDetailsImpl) principal).getId();


            Follow isFollwin = followRepository.findBySource_useridAndTarget_userid(userid, id);

            userProfile.setFollowing(isFollwin != null);


            return userProfile;



        }
        catch (Exception e)
        {
            return null;
        }
    }


    @Transactional
    public UserProfile updateUserProfile(UserProfile userProfile)
    {

            userProfile.setUser_id(userProfile.getId());
            return userProfileRepository.save(userProfile);

    }


    public void deleteUserProfile(Long id)
    {
        try
        {
            userProfileRepository.deleteById(id);
            userRepository.deleteById(id);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
