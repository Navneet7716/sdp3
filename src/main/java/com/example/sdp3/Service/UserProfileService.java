package com.example.sdp3.Service;


import com.example.sdp3.Pojo.UserProfile;
import com.example.sdp3.Repository.UserProfileRepository;
import com.example.sdp3.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
public class UserProfileService {

    @Autowired
    UserProfileRepository userProfileRepository;
    @Autowired
    UserRepository userRepository;

    public UserProfile getUserProfileById(Long id)
    {
        try
        {
            return userProfileRepository.findById(id).get();
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
