package com.example.sdp3.Controller;


import com.example.sdp3.Pojo.Follow;
import com.example.sdp3.Service.FollowService;
import com.example.sdp3.payload.response.FollowResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(value = "*",maxAge = 3600)
@RestController
@RequestMapping("/api/follow")
public class FollowController {

    final
    FollowService followService;

    public FollowController(FollowService followService) {
        this.followService = followService;
    }


    @GetMapping("/getfollowers/{id}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<FollowResponse> getFollowers(@PathVariable Long id) {
        FollowResponse followResponse = new FollowResponse();
        try {
            followResponse.Follower_ListData = followService.GetFollowers(id);
            followResponse.follower_count = followResponse.Follower_ListData.size();
            followResponse.error=false;
            followResponse.message="success";
            return ResponseEntity.ok(followResponse);
        }
        catch(Exception e) {
            followResponse.error=true;
            followResponse.message=e.getMessage();

            return ResponseEntity.status(400).body(followResponse);
        }
    }

    @GetMapping("/getFollows/{id}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<FollowResponse> getFollows(@PathVariable Long id) {
        FollowResponse followResponse = new FollowResponse();
        try {
            followResponse.Follow_ListData = followService.GetFollows(id);
            followResponse.follower_count = followResponse.Follow_ListData.size();
            followResponse.error=false;
            followResponse.message="success";
            return ResponseEntity.ok(followResponse);
        }
        catch(Exception e) {
            followResponse.error=true;
            followResponse.message=e.getMessage();

            return ResponseEntity.status(400).body(followResponse);
        }
    }

    @GetMapping("/getFollowsandFollowers/{id}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<FollowResponse> getFollowsandFollowers(@PathVariable Long id) {
        FollowResponse followResponse = new FollowResponse();
        try {
            followResponse.Follow_ListData = followService.GetFollows(id);
            followResponse.Follower_ListData = followService.GetFollowers(id);
            followResponse.follows_count = followResponse.Follow_ListData.size();
            followResponse.follower_count = followResponse.Follower_ListData.size();
            followResponse.error=false;
            followResponse.message="success";
            return ResponseEntity.ok(followResponse);
        }
        catch(Exception e) {
            followResponse.error=true;
            followResponse.message=e.getMessage();

            return ResponseEntity.status(400).body(followResponse);
        }
    }

    @PostMapping("/follow")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<FollowResponse> follow(@RequestBody Follow follow) {
        FollowResponse followResponse = new FollowResponse();
        try {
            followService.create(follow);
            followResponse.message="success";
            followResponse.error=false;

            return ResponseEntity.ok(followResponse);
        }
        catch (Exception e) {
            followResponse.error=true;
            followResponse.message=e.getMessage();
            return ResponseEntity.status(400).body(followResponse);
        }

    }

    @DeleteMapping("/unfollow")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<FollowResponse> unfollowit(@RequestBody Follow follow) {
        FollowResponse followResponse = new FollowResponse();

        try {
            followService.unfollow(follow.getSource_userid(),follow.getTarget_userid());
            followResponse.message="success";
            followResponse.error=false;
            return ResponseEntity.ok(followResponse);
        }
        catch (Exception e) {
            followResponse.error= true;
            followResponse.message=e.getMessage();
            return ResponseEntity.status(404).body(followResponse);
        }

    }




}
