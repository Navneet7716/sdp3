package com.example.sdp3.Service;


import com.example.sdp3.Pojo.UserProfile;
import com.example.sdp3.Repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserProfileService {

    @Autowired
    UserProfileRepository userProfileRepository;

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
}
