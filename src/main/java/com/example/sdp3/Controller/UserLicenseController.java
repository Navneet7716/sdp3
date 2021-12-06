package com.example.sdp3.Controller;


import com.example.sdp3.Pojo.UserLicense;
import com.example.sdp3.Pojo.UserProfile;
import com.example.sdp3.Service.UserLicenseService;
import com.example.sdp3.Service.UserProfileService;
import com.example.sdp3.payload.response.UserLicenseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/test")
public class UserLicenseController {

    @Autowired
    UserLicenseService userLicenseService;

    @Autowired
    UserProfileService userProfileService;


    @GetMapping("user/licenses/{id}")
    public UserLicenseResponse getAllLicenses(@PathVariable Long id)
    {
        UserProfile userProfile = userProfileService.getUserProfileById(id);
        if(userProfile == null)
        {
            return new UserLicenseResponse("User Profile Not Found" , false , null);
        }
        try
        {
            List<UserLicense> data = userLicenseService.getAllLicenses(id);
            return new UserLicenseResponse("Licenses Available " , true ,data);
        }
        catch(Exception e)
        {
            return new UserLicenseResponse("Error Occured" , false , null);
        }
    }

    @PostMapping("/create/license/{id}")
    public UserLicenseResponse createuserLicense(@RequestBody UserLicense userLicense, @PathVariable Long id)
    {
        UserProfile userProfile = userProfileService.getUserProfileById(id);
        if(userProfile == null)
        {
            return new UserLicenseResponse("User Profile Not Found" , false , null);
        }
        try{

            userLicenseService.createUserLicense(id,userLicense);
            return new UserLicenseResponse("Uploaded Successfully" , true , null);
        }
        catch(Exception e)
        {
            return new UserLicenseResponse("Error Occured" , false , null);
        }

    }


    @DeleteMapping("/user/delete/license/{id}")
    public UserLicenseResponse deleteUserLicense(@PathVariable Long id)
    {
        UserLicense userLicense = userLicenseService.getUserLicenseById(id);

        if(userLicense == null)
        {
            return new UserLicenseResponse("License Not found" , false , null);
        }

        try
        {
            userLicenseService.deleteUserLicense(id);
            return new UserLicenseResponse("License Deleted Successfully" , true ,null);
        }
        catch (Exception e)
        {
            return new UserLicenseResponse("Error Occured" , false , null);
        }
    }

    @PutMapping("user/license/update")
    public UserLicenseResponse updateUserProfile(@RequestBody UserLicense userLicense)
    {

        UserLicense userLicense_new = userLicenseService.getUserLicenseById(userLicense.getId());

        if(userLicense_new == null )
        {
            return new UserLicenseResponse("UserLicense Not Found" , false,null);
        }

        try
        {
            userLicenseService.updateUserLicense(userLicense);
            return new UserLicenseResponse("License Updated Successfully" , true, null);
        }
        catch(Exception e)
        {
            return new UserLicenseResponse("Licence Update Failed" , false, null);
        }
    }


}
