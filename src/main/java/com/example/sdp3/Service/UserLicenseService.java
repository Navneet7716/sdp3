package com.example.sdp3.Service;

import com.example.sdp3.Pojo.UserLicense;
import com.example.sdp3.Repository.UserLicenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class UserLicenseService {

    @Autowired
    UserLicenseRepository userLicenseRepository;

    public List<UserLicense> getAllUserLicenses(Long id)
    {
        return userLicenseRepository.findUserLicenseByUser_id(id).orElseThrow(() -> new IllegalStateException("No License found"));
    }

    public void createUserLicense(Long id , UserLicense userLicense)
    {
        try
        {
            userLicense.setUser_id(id);
            userLicenseRepository.save(userLicense);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }

    public void deleteUserLicense(Long id)
    {
       boolean b = userLicenseRepository.existsById(id);
       if (!b) {
           throw new IllegalStateException("License Doesn't Exists");
       }

       userLicenseRepository.deleteById(id);
    }

    public UserLicense getUserLicenseById(Long id)
    {
        return userLicenseRepository.findById(id).orElseThrow(() -> new IllegalStateException("License Not found!"));
    }


    public void updateUserLicense(UserLicense userLicense)
    {
       UserLicense userLicense1 = userLicenseRepository.findById(userLicense.getId()).orElseThrow(() -> new IllegalStateException("License Not Found!"));

        if (userLicense.getLicense_name().length() > 0 && !Objects.equals(userLicense1.getLicense_name(), userLicense.getLicense_name()) ) {
            userLicenseRepository.save(userLicense);

        }


    }


}
