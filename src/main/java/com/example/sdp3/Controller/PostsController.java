package com.example.sdp3.Controller;

import com.example.sdp3.Pojo.Posts;
import com.example.sdp3.Service.PostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/post")
public class PostsController{
    @Autowired
    PostsService postsService;

    @PostMapping("/addposts")
    @PreAuthorize("hasRole('USER')")
    public Postreturn addNewPosts(@RequestBody Posts posts){
         Postreturn response = new Postreturn();

        try{
            postsService.addPosts(posts);
            response.message = "Added Successfully";
            response.error = false;
        }
        catch(Exception e){

            response.message = e.getMessage();
            response.error = true;
        }
        return response;
    }

    @GetMapping("/getallposts")
    @PreAuthorize("hasRole('USER')")
    public Postreturn getPosts(){
        Postreturn response = new Postreturn();
        try{
            response.ListData = postsService.getAllPosts();
            response.message = "Success";
            response.error = false;
        }
        catch(Exception e){

            response.message=e.getMessage();
            response.error=false;
        }
        return response;
    }

    @GetMapping("/getpostbyid/{id}")
    @PreAuthorize("hasRole('USER')")
    public Postreturn getPostById(@PathVariable Long id){
        Postreturn response = new Postreturn();
        try{
            response.data = postsService.findPostById(id);
            response.message = "Found the Post";
            response.error = false;
        }
        catch(Exception e){

            response.message = e.getMessage();
            response.error = true;
        }
        return response;
    }

    @DeleteMapping("/deletepostbyid/{id}")
    @PreAuthorize("hasRole('USER')")
    public Postreturn deleteApplicantById(@PathVariable  Long id){
        Postreturn response = new Postreturn();
        try{
            postsService.deletePostsById(id);
            response.message = "Deleted Successfully";
            response.error = false;
        }
        catch(Exception e){

            response.message = e.getMessage();
            response.error = true;
        }
        return response;
    }

    @PatchMapping("/updatepost")
    @PreAuthorize("hasRole('USER')")
    public Postreturn updateApplicant(@RequestBody Posts updatedpost){
        Postreturn response = new Postreturn();
        try{
            postsService.updatePost(updatedpost);
            response.message = "Successfully updated "+ updatedpost.getId();
            response.error = false;
        }
        catch(Exception e){
            response.message = e.getMessage();
            response.error = true;
        }
        return response;
    }

}
