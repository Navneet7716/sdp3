package com.example.sdp3.Repository;


import com.example.sdp3.Pojo.Follow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FollowRepository extends JpaRepository<Follow, Long> {

    @Query("select f from Follow f where f.target_userid=?1")
    Optional<List<Follow>> getFollowers(Long targetID);

    @Query("select f from Follow f where f.source_userid=?1")
    Optional<List<Follow>> getFollow(Long sourceID);

    @Query("delete from Follow f where f.source_userid=?1 and f.target_userid=?2")
    void unFollow(Long source_id, Long target_id);

    @Query("select f from Follow f where f.source_userid=?1 and f.target_userid=?2")
    Follow findBySource_useridAndTarget_userid(Long source_id, Long target_id);
}
