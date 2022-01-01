package com.example.sdp3.Pojo;

import com.vladmihalcea.hibernate.type.array.ListArrayType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.lang.reflect.Array;
import java.util.Date;
import java.util.List;

@TypeDef(
        name = "list-array",
        typeClass = ListArrayType.class
)
@Entity
@Table
public class Posts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Long id;


    @Column()
    @NotNull
    private Long userId;

    @Column(name="image", nullable=true)
    private String image;

    @Column
    @NotNull
    private String description;

    @Column
    @NotNull
    private String postType;

    @Column(nullable = true)
    private Long parentId;

    @Column
    @NotNull
    private String title;

    @Type(type = "list-array")
    @Column(
            columnDefinition = "text[]"
    )
    private List<String> hashtags;

    @Column(updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt = new Date();

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt = new Date();

    @Column()
    private Long likeCount = 0l;

    @Transient
    private boolean isLiked;

    @Transient
    private UserProfile userData;



    public Posts(UserProfile userData,Long user_id,boolean isLiked, String image, String description, String post_type, Long parentId, String title, List<String> hashtags, Long like_count) {

        this.userId = user_id;
        this.userData = userData;
        this.image = image;
        this.description = description;
        this.postType = post_type;
        this.parentId = parentId;
        this.title = title;
        this.hashtags = hashtags;
        this.likeCount = like_count;
        this.isLiked = isLiked;
    }

    public Posts(){

    }

    public UserProfile getUserData() {
        return userData;
    }

    public void setUserData(UserProfile userData) {
        this.userData = userData;
    }

    public boolean isLiked() {
        return isLiked;
    }

    public void setLiked(boolean liked) {
        isLiked = liked;
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

    public void setUserId(Long userData) {
        this.userId = userData;
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
        return postType;
    }

    public void setPost_type(String post_type) {
        this.postType = post_type;
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
        return createdAt;
    }


//
//    @PreUpdate
//    public void setCreatedAt() {
//        this.createdAt= new Date();
//    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    public Date getUpdated_at() {
        return updatedAt;
    }

    public void setUpdated_at(Date updated_at) {
        this.updatedAt = updated_at;
    }

    public Long getLike_count() {
        return likeCount;
    }

    public void setLike_count(Long like_count) {
        this.likeCount = like_count;
    }
}
