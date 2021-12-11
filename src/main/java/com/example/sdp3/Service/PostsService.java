package com.example.sdp3.Service;


import com.example.sdp3.Pojo.Posts;
import com.example.sdp3.Repository.PostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


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

    public List<Posts> getAllPosts(){
        List<Posts> posts = postsRepository.findAll();
        if(posts.size()!=0){
            return posts;
        }
        else{
            throw new IllegalStateException("Post Don't Exist");
        }
    }

    public Posts findPostById(Long id){
        return postsRepository.findById(id).orElseThrow(() -> new IllegalStateException("Post was not found"));
    }

    public List<Posts> getAllPostByUserId(Long id) {
        return postsRepository.findAllByUser_id(id).orElseThrow(() -> new IllegalStateException("No Posts available."));
    }

    public Posts getPostByUserId(Long id) {
        return postsRepository.findByUser_id(id).orElseThrow(() -> new IllegalStateException("No Posts available."));
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
