package com.example.sdp3.Service;


import com.example.sdp3.Pojo.Follow;
import com.example.sdp3.Pojo.Posts;
import com.example.sdp3.Pojo.User;
import com.example.sdp3.Pojo.UserActivity;
import com.example.sdp3.Repository.FollowRepository;
import com.example.sdp3.Repository.PostsRepository;
import com.example.sdp3.Repository.UserActivityRepository;
import com.example.sdp3.Repository.UserProfileRepository;
import com.example.sdp3.Security.services.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.security.core.Authentication;


@Service
public class PostsService {

    @Autowired
    PostsRepository postsRepository;

    @Autowired
    UserProfileRepository userProfileRepository;

    @Autowired
    UserActivityRepository userActivityRepository;

    @Autowired
    FollowRepository followRepository;

    public Posts addPosts(Posts posts) {

        Posts newpost = postsRepository.save(posts);

        newpost.setUserData(userProfileRepository.findAllByUserId(newpost.getUserId()));

        return newpost;
    }

    public void deletePostsById(Long id) {
        postsRepository.deleteById(id);
    }

    public Page<Posts> getAllPosts(Integer pageNo, Integer pageSize, String sortBy) {

        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).descending());

        Page<Posts> pagedResults = postsRepository.findAllByPostType("parent", paging);


        return getPosts(pagedResults);

//        if(pagedResult.hasContent()) {
////            return pagedResult.getContent();
//            return pagedResult;
//        } else {
//            return new Page();
//        }
    }

    public Optional<Posts> findPostById(Long id) {
        Optional<Posts> p = postsRepository.findById(id);

        p.ifPresent((e) -> {
            e.setUserData(userProfileRepository.findAllByUserId(e.getUserId()));

            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

            Long userid = ((UserDetailsImpl) principal).getId();


            Optional<UserActivity> userActivity = userActivityRepository.findAllByUserIdAndPostId(userid, e.getId());

            if (userActivity.isPresent()) {
                userActivity.ifPresent((el1) -> e.setLiked(el1.getIsliked()));
            }


        });

        return p;

    }

    public Page<Posts> getAllPostByUserId(Integer pageNo, Integer pageSize, String sortBy, Long userId) {

        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).descending());


        Page<Posts> pagedResults = postsRepository.findAllByUserIdAndPostType(userId, "parent", paging);

        return getPosts(pagedResults);


    }

    public Page<Posts> getAllPostBasedOnFollowers(Integer pageNo, Integer pageSize, String sortBy, Long userId) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).descending());

        List<Follow> follows = followRepository.getFollow(userId).get();

        ArrayList<Long> followIds = new ArrayList<>();

        follows.forEach(e -> followIds.add(e.getTarget_userid()));

        Page<Posts> pagedResults = postsRepository.findAllByPostTypeAndUserIdIn("parent", followIds, paging);

        return getPosts(pagedResults);
    }


    public Page<Posts> getPosts(Page<Posts> pagedResults) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Long userid = ((UserDetailsImpl) principal).getId();


        pagedResults.getContent().forEach((el) -> {

            el.setUserData(userProfileRepository.findAllByUserId(el.getUserId()));


            Optional<UserActivity> userActivity = userActivityRepository.findAllByUserIdAndPostId(userid, el.getId());

            if (userActivity.isPresent()) {
                userActivity.ifPresent((el1) -> el.setLiked(el1.getIsliked()));
            }


        });

        return pagedResults;
    }

    public List<Posts> getAllCommentsBYPOSTID(Long parentId) {

        List<Posts> posts = postsRepository.findAllByPostTypeAndParentId("comment", parentId);

        posts.forEach(el -> {
            el.setUserData(userProfileRepository.findAllByUserId(el.getUserId()));
        });

        return posts;


    }

    @Transactional
    public Posts updatePost(Posts updatePost) {
        Optional<Posts> posts = postsRepository.findById(updatePost.getId());

        if (posts.isPresent()) {
            return postsRepository.save(updatePost);
        } else {
            throw new IllegalStateException("Post is not found");
        }

    }

}
