package com.example.sdp3.Controller;


import com.example.sdp3.Pojo.UserActivity;
import com.example.sdp3.Service.UserActivityService;
import com.example.sdp3.payload.request.GetActivity;
import com.example.sdp3.payload.response.ActivityResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/activity")
public class UserActivityController {

    final
    UserActivityService userActivityService;


    public UserActivityController(UserActivityService userActivityService) {
        this.userActivityService = userActivityService;
    }

    @GetMapping("/getActivity")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<ActivityResponse> GetActivity(@RequestBody GetActivity getActivity) {
        ActivityResponse activityResponse = new ActivityResponse();
        try {
            activityResponse.data = userActivityService.getByUserIDAndPostID((long) getActivity.user_id, (long) getActivity.post_id);
            activityResponse.error=false;
            activityResponse.message="success";

           return ResponseEntity.status(200).body(activityResponse);

        }
        catch (Exception e) {
            activityResponse.message=e.getMessage();
            activityResponse.error=true;
            return ResponseEntity.status(400).body(activityResponse);

        }
    }

    @GetMapping("/getlikecount/{post_id}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<ActivityResponse> GetLinkCount(@PathVariable Long post_id) {
        ActivityResponse activityResponse = new ActivityResponse();
        try {
            activityResponse.dataint = userActivityService.GetLikeCount(post_id);
            activityResponse.error=false;
            activityResponse.message="success";
            return ResponseEntity.status(200).body(activityResponse);

        }
        catch (Exception e) {
            activityResponse.message=e.getMessage();
            activityResponse.error=true;
            return ResponseEntity.status(400).body(activityResponse);

        }
    }

    @PostMapping("/create")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<ActivityResponse> createActivity(@RequestBody UserActivity userActivity) {
        ActivityResponse activityResponse = new ActivityResponse();
        try {
            userActivityService.createUserActivity(userActivity);
            activityResponse.error=false;
            activityResponse.message="success";
            return ResponseEntity.status(200).body(activityResponse);

        }
        catch (Exception e) {
            activityResponse.message=e.getMessage();
            activityResponse.error=true;
            return ResponseEntity.status(400).body(activityResponse);

        }
    }

}
