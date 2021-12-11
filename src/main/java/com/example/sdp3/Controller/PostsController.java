package com.example.sdp3.Controller;

import com.example.sdp3.Pojo.Posts;
import com.example.sdp3.Service.PostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(value = "*",maxAge = 3600)
@RestController
@RequestMapping("/api/post")
public class PostsController{
    final
    PostsService postsService;

    public PostsController(PostsService postsService) {
        this.postsService = postsService;
    }

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
    public ResponseEntity<List<Posts>> getPosts(  @RequestParam(defaultValue = "0") Integer pageNo,
                                                  @RequestParam(defaultValue = "10") Integer pageSize,
                                                  @RequestParam(defaultValue = "id") String sortBy){
        List<Posts> list = postsService.getAllPosts(pageNo, pageSize, sortBy);

        return new ResponseEntity<>(list, new HttpHeaders(), HttpStatus.OK);
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

    @GetMapping("/getallpostbyuserid/{id}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<List<Posts>> getallPostByUSERID( @RequestParam(defaultValue = "0") Integer pageNo,
                                                           @RequestParam(defaultValue = "10") Integer pageSize,
                                                           @RequestParam(defaultValue = "id") String sortBy,@PathVariable Long id){
        List<Posts> list = postsService.getAllPostByUserId(pageNo, pageSize, sortBy, id);

        return new ResponseEntity<>(list, new HttpHeaders(), HttpStatus.OK);
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
