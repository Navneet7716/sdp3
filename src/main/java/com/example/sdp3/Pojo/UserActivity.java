package com.example.sdp3.Pojo;


import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="useractivity_table")
public class UserActivity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Long id;

    @Column()
    private Long user_id;

    @Column()
    private Long post_id;

    @Column()
    private boolean like;


    @Column
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date created_at = new Date();

    public UserActivity() {

    }


    @PreUpdate
    public void setCreated_at() {
        this.created_at= new Date();
    }

    public Date getCreated_at() {return this.created_at;}

    public UserActivity(Long id, Long user_id, Long post_id, boolean like, Date created_at) {
        this.id = id;
        this.user_id = user_id;
        this.post_id = post_id;
        this.like = like;
        this.created_at = created_at;
    }

    @Override
    public String toString() {
        return "UserActivity{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", post_id=" + post_id +
                ", like=" + like +
                ", created_at=" + created_at +
                '}';
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

    public Long getPost_id() {
        return post_id;
    }

    public void setPost_id(Long post_id) {
        this.post_id = post_id;
    }

    public boolean isLike() {
        return like;
    }

    public void setLike(boolean like) {
        this.like = like;
    }
}
