package com.example.sdp3.Service;


import com.example.sdp3.Pojo.User;
import com.example.sdp3.Repository.RoleRepository;
import com.example.sdp3.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    public List<User> getAllUsers()
    {
        return (List<User>) userRepository.findAll();
    }

    public User getUserById(Long id)
    {
        try
        {
            return userRepository.findById(id).get();
        }
        catch (Exception e)
        {
            return null;
        }
    }

    public void deleteUserById(Long id)
    {
        try
        {
            userRepository.deleteById(id);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    public void updateUser(User user)
    {
        try
        {
            userRepository.save(user);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }

}
