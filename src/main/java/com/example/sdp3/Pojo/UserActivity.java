package com.example.sdp3.Pojo;


import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="activity_table")
public class UserActivity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Long id;

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private Long postId;

    @Column(columnDefinition = "boolean default false")
    private Boolean isliked;

    @Column
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt = new Date();


    public UserActivity() {

    }


    @PreUpdate
    public void setCreated_at() {
        this.createdAt= new Date();
    }

    public Date getCreated_at() {return this.createdAt;}

    public UserActivity(Long id, Long userId, Long postId, Boolean isliked, Date created_at) {
        this.id = id;
        this.userId = userId;
        this.postId = postId;
        this.isliked = isliked;
        this.createdAt = created_at;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public Boolean getIsliked() {
        return isliked;
    }

    public void setIsliked(Boolean isliked) {
        this.isliked = isliked;
    }

    public void setCreated_at(Date created_at) {
        this.createdAt = created_at;
    }
}
