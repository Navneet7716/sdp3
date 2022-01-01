package com.example.sdp3.Controller;


import com.example.sdp3.Pojo.UserProfile;
import com.example.sdp3.Service.UserProfileService;
import com.example.sdp3.payload.response.MessageResponse;
import com.example.sdp3.payload.response.UserProfileResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@CrossOrigin(value = "*",maxAge = 3600)
@RestController
@RequestMapping("/api/profile")
public class UserProfileController {

    final
    UserProfileService userProfileService;

    public UserProfileController(UserProfileService userProfileService) {
        this.userProfileService = userProfileService;
    }


    @GetMapping("/user/profile/{id}")
    @PreAuthorize("hasRole('USER')")
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

    @PutMapping("user/profile/update")
    @PreAuthorize("hasRole('USER')")
    public UserProfileResponse updateUserProfile(@RequestBody UserProfile userProfile)
    {

        UserProfile userProfile_new = userProfileService.getUserProfileById(userProfile.getId());

        if(userProfile_new == null )
        {
            return new UserProfileResponse("UserProfile Not Found" , false,null);
        }

        try
        {

            return new UserProfileResponse("Profile Updated Successfully" , true, List.of(userProfileService.updateUserProfile(userProfile)));
        }
        catch(Exception e)
        {
            return new UserProfileResponse("Profile Updated Failed" , false, null);
        }
    }


    @DeleteMapping("/user/profile/delete/{id}")
    @PreAuthorize("hasRole('USER')")
    public UserProfileResponse deleteUserProfileById(@PathVariable Long id)
    {
        UserProfile userProfile = userProfileService.getUserProfileById(id);

        if(userProfile == null)
        {
            return new UserProfileResponse("UserProfile Not found" , false , null);
        }
        try
        {
            userProfileService.deleteUserProfile(id);
            return new UserProfileResponse("User Deleted Successfully" , true , null);
        }
        catch(Exception e)
        {
            return new UserProfileResponse("User Cannot Be Deleted" , false , null);
        }
    }





}
