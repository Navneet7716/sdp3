package com.example.sdp3.Service;


import com.example.sdp3.Pojo.Posts;
import com.example.sdp3.Repository.PostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;


@Service
public class PostsService{

    @Autowired
    PostsRepository postsRepository;

    public void addPosts(Posts posts){
        postsRepository.save(posts);
    }

    public void deletePostsById(Long id){
        postsRepository.deleteById(id);
    }

    public Page<Posts> getAllPosts(Integer pageNo, Integer pageSize, String sortBy){

        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).descending());

        return postsRepository.findAll(paging);

//        if(pagedResult.hasContent()) {
////            return pagedResult.getContent();
//            return pagedResult;
//        } else {
//            return new Page();
//        }
    }

    public Posts findPostById(Long id){
        return postsRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Post was not found"));
    }

    public Page<Posts> getAllPostByUserId(Integer pageNo, Integer pageSize, String sortBy, Long userId) {

        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).descending());

        return postsRepository.findAllByUserId(userId,paging);
        //        if(pagedResult.hasContent()) {
//           return pagedResult.getContent();
//        } else {
//            return new ArrayList<Posts>();
//        }


    }

    @Transactional
    public void updatePost(Posts updatePost){
        Optional<Posts> posts = postsRepository.findById(updatePost.getId());

        if(posts.isPresent()){
            postsRepository.save(updatePost);
        }
        else{
            throw new IllegalStateException("Post is not found");
        }

    }

}
