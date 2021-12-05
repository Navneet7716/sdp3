package com.example.sdp3.Controller;

import com.example.sdp3.Pojo.User;
import com.example.sdp3.Repository.UserRepository;
import com.example.sdp3.Service.UserService;
import com.example.sdp3.payload.response.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {

    @Autowired
    UserService userService;

    @GetMapping("/all")
    public String allAccess() {
        return "Public Content.";
    }

    @GetMapping("/user")
    @PreAuthorize("hasRole('USER')")
    public String userAccess() {
        return "User Content.";
    }

    @GetMapping("/all/users")
    public MessageResponse getAllUsers()
    {
        List<User> data = userService.getAllUsers();
        try
        {
            if(data.size() != 0)
            return new MessageResponse("Users Available are",true,data);
            else{
                return new MessageResponse("No Users Available",false,null);
            }
        }
        catch (Exception e)
        {
            return new MessageResponse("Error Occured",false,null);
        }
    }

    @GetMapping("/user/{id}")
    public MessageResponse getUserById(@PathVariable Long id)
    {
        User user = userService.getUserById(id);
        if(user == null)
        {
            return new MessageResponse("No Users with Id : "+ id,false,null);
        }

        List<User> data = new ArrayList<>();
        data.add(user);
        try
        {
                return new MessageResponse("Users Available ",true,data);
        }
        catch (Exception e)
        {
            return new MessageResponse("Error Occured",false,null);
        }
    }

    @PutMapping("/user/update")
    public MessageResponse updateUser(@RequestBody User user)
    {
        try {
            User user1 = userService.getUserById(user.getId());
            if(user1 != null)
            {
                userService.updateUser(user);
                List<User> data = new ArrayList<>();
                data.add(user);
                return new MessageResponse("User Updated Successfully with id: "+ user.getId(), true,data);
            }
            else
            {
                return new MessageResponse("Error Occured" , false,null);
            }
        }
        catch (Exception e)
        {
            return new MessageResponse("Error Occured" , false,null);
        }

    }

    @DeleteMapping("/user/delete/{id}")
    public MessageResponse deleteUserById(@PathVariable Long id)
    {
        User user = userService.getUserById(id);
        List<User> data = new ArrayList<>();
        data.add(user);
        if(user == null)
        {
            return new MessageResponse("No User with Id:" + id,false,null);
        }
        userService.deleteUserById(id);
        return new MessageResponse("User Deleted Successfully with id: " + id, true,data);
    }
}
