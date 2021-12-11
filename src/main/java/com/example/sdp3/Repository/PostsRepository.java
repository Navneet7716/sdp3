package com.example.sdp3.Repository;

import com.example.sdp3.Pojo.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostsRepository extends JpaRepository<Posts, Long> {

    @Query("select p from Posts p where p.user_id=?1")
    Optional<List<Posts>> findAllByUser_id(Long id);

    @Query("select p from Posts p where p.user_id=?1")
    Optional<Posts> findByUser_id(Long id);

}
