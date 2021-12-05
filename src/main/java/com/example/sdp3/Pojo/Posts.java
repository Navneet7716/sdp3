package com.example.sdp3.Pojo;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.lang.reflect.Array;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "posts_table")
public class Posts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Long id;

    @Column
    private Long user_id;

    @Column(name="profile_image", nullable=false)
    private String image;

    @Column
    private String description;

    @Column
    private String post_type;

    @Column
    private Long parentId;

    @Column
    private String title;

    @Column
    @ElementCollection
    private List<String> hashtags;

    @Column
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date created_at = new Date();

    @Column
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated_at = new Date();

    @Column
    private Long like_count;

    public Posts(Long user_id, String image, String description, String post_type, Long parentId, String title, List<String> hashtags, Long like_count) {
        this.user_id = user_id;
        this.image = image;
        this.description = description;
        this.post_type = post_type;
        this.parentId = parentId;
        this.title = title;
        this.hashtags = hashtags;
        this.like_count = like_count;
    }

    public Posts(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPost_type() {
        return post_type;
    }

    public void setPost_type(String post_type) {
        this.post_type = post_type;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getHashtags() {
        return hashtags;
    }

    public void setHashtags(List<String> hashtags) {
        this.hashtags = hashtags;
    }

    public Date getCreated_at() {
        return created_at;
    }

    @PreUpdate
    public void setUpdatedAt() {
        this.created_at= new Date();
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public Long getLike_count() {
        return like_count;
    }

    public void setLike_count(Long like_count) {
        this.like_count = like_count;
    }
}
