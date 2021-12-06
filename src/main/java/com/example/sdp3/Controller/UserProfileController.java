package com.example.sdp3.Controller;


import com.example.sdp3.Pojo.UserProfile;
import com.example.sdp3.Service.UserProfileService;
import com.example.sdp3.payload.response.MessageResponse;
import com.example.sdp3.payload.response.UserProfileResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/test")
public class UserProfileController {

    @Autowired
    UserProfileService userProfileService;


    @GetMapping("/user/profile/{id}")
    public UserProfileResponse getUserById(@PathVariable Long id)
    {
        UserProfile userProfile = userProfileService.getUserProfileById(id);

        if(userProfile == null)
        {
            return new UserProfileResponse("UserProfile Not Found" , false,null);
        }
        try
        {
            List<UserProfile> data = new ArrayList<>();
            data.add(userProfile);
            return new UserProfileResponse("UserProfile Available" , true,data);

        }
        catch (Exception e)
        {
            return new UserProfileResponse("Error Occured" , false,null);

        }
    }





}
