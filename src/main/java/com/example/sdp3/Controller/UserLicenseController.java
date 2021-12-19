package com.example.sdp3.Controller;


import com.example.sdp3.Pojo.UserLicense;
import com.example.sdp3.Pojo.UserProfile;
import com.example.sdp3.Service.UserLicenseService;
import com.example.sdp3.Service.UserProfileService;
import com.example.sdp3.payload.response.UserLicenseResponse;
import com.example.sdp3.payload.response.UserProfileResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(value = "*",maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class UserLicenseController {

    final
    UserLicenseService userLicenseService;

    final
    UserProfileService userProfileService;

    public UserLicenseController(UserLicenseService userLicenseService, UserProfileService userProfileService) {
        this.userLicenseService = userLicenseService;
        this.userProfileService = userProfileService;
    }


    @GetMapping("user/licenses/{id}")
    @PreAuthorize("hasRole('USER')")
    public UserLicenseResponse getAllLicenses(@PathVariable Long id)
    {
        try
        {
            List<UserLicense> data = userLicenseService.getAllUserLicenses(id);
            return new UserLicenseResponse("Licenses Available " , true ,data);
        }
        catch(Exception e)
        {
            return new UserLicenseResponse("Error Occured" , false , null);
        }
    }

    @PostMapping("/create/license/{id}")
    @PreAuthorize("hasRole('USER')")
    public UserLicenseResponse createuserLicense(@RequestBody UserLicense userLicense, @PathVariable Long id)
    {
        try{

           UserLicense userLicense1 = userLicenseService.createUserLicense(id,userLicense);
            return new UserLicenseResponse("Uploaded Successfully" , true , List.of(userLicense1));
        }
        catch(Exception e)
        {
            return new UserLicenseResponse("Error Occured" , false , null);
        }

    }


    @DeleteMapping("/user/delete/license/{id}")
    @PreAuthorize("hasRole('USER')")
    public UserLicenseResponse deleteUserLicense(@PathVariable Long id)
    {
       try {
           userLicenseService.deleteUserLicense(id);
           return new UserLicenseResponse("Deleted Successfully",true,null);
       }
       catch (Exception e) {
           return new UserLicenseResponse(e.getMessage(), false,null);
       }
    }

    @PutMapping("user/license/update")
    @PreAuthorize("hasRole('USER')")
    public UserLicenseResponse updateUserLicense(@RequestBody UserLicense userLicense)
    {

        UserLicense userLicense_new = userLicenseService.getUserLicenseById(userLicense.getId());

        if(userLicense_new == null )
        {
            return new UserLicenseResponse("UserLicense Not Found" , false,null);
        }

        try
        {

            return new UserLicenseResponse("License Updated Successfully" , true,  List.of(userLicenseService.updateUserLicense(userLicense)));
        }
        catch(Exception e)
        {
            return new UserLicenseResponse("Licence Update Failed" , false, null);
        }
    }


}
