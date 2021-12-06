package com.example.sdp3.Service;

import com.example.sdp3.Pojo.UserLicense;
import com.example.sdp3.Repository.UserLicenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserLicenseService {

    @Autowired
    UserLicenseRepository userLicenseRepository;

    public List<UserLicense> getAllLicenses(Long id)
    {
        try
        {
            List<UserLicense> userLicenses = new ArrayList<>();
            List<UserLicense> data = (List<UserLicense>)userLicenseRepository.findAll();
            for(UserLicense userLicense: data)
            {
                if (userLicense.getUser_id() == id)
                {
                    userLicenses.add(userLicense);
                }
            }
            return userLicenses;
        }
        catch(Exception e)
        {
            return null;
        }
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
        try
        {
            userLicenseRepository.deleteById(id);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    public UserLicense getUserLicenseById(Long id)
    {
        try {
            return userLicenseRepository.findById(id).get();
        }
        catch(Exception e)
        {
           return null;
        }
    }


    public void updateUserLicense(UserLicense userLicense)
    {
        try
        {
            userLicense.setUser_id(userLicense.getId());
            userLicenseRepository.save(userLicense);
        }
        catch (Exception e)
        {
            System.out.println("Error Occured while updating the User Profile");
        }

    }


}
