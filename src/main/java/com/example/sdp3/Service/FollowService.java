package com.example.sdp3.Service;

import com.example.sdp3.Pojo.Follow;
import com.example.sdp3.Repository.FollowRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class FollowService {

    final
    FollowRepository followRepository;


    public FollowService(FollowRepository followRepository) {
        this.followRepository = followRepository;
    }

    public void create(Follow follow) {
        followRepository.save(follow);
    }

    public List<Follow> GetFollowers(Long id) {

        return followRepository.getFollowers(id).orElseThrow(() -> new IllegalStateException("No followers.."));

    }

    public List<Follow> GetFollows(Long id) {

        return followRepository.getFollow(id).orElseThrow(() -> new IllegalStateException("No followers.."));

    }

        @Transactional
        public void unfollow(Long source_id, Long target_id) {

        Follow b = followRepository.findBySource_useridAndTarget_userid(source_id, target_id);

        if (b == null) {
            throw new IllegalStateException("Couldn't find record.");
        }

        followRepository.deleteBySourceUseridAndTargetUserid(source_id,target_id);


    }

}
