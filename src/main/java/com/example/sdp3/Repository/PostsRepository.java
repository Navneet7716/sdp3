package com.example.sdp3.Repository;

import com.example.sdp3.Pojo.Posts;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostsRepository extends PagingAndSortingRepository<Posts, Long> {
    Page<Posts> findAllByUserId(Long id, Pageable pageable);

    Page<Posts> findAllByPostType(String posttype, Pageable pageable);

    List<Posts> findAllByPostTypeAndParentId(String postType, Long parentId);
}
