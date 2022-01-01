package com.example.sdp3.Pojo;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "applicants_table")
public class Applicant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Long id;

    @Column
    @NotNull
    private Long user_id;

    @Column
    @NotNull
    private Long job_id;

    @Column()
    @NotNull
    private Boolean status= false;

    @Column(updatable = false)
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date created_at = new Date();

    @Transient
    private Jobs postData;

    @Transient
    private UserProfile userData;

    public Applicant(Long user_id, Long job_id, Boolean status, Jobs postData, UserProfile userData) {
        this.user_id = user_id;
        this.job_id = job_id;
        this.status = status;
        this.postData = postData;
        this.userData = userData;
    }

    public UserProfile getUserData() {
        return userData;
    }

    public void setUserData(UserProfile userData) {
        this.userData = userData;
    }

    public Applicant(){
    }

    public Jobs getPostData() {
        return postData;
    }

    public void setPostData(Jobs postData) {
        this.postData = postData;
    }

    public void setUpdatedAt() {
        this.created_at= new Date();
    }

    public Date getCreated_at(){
        return this.created_at;
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

    public Long getJob_id() {
        return job_id;
    }

    public void setJob_id(Long job_id) {
        this.job_id = job_id;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Applicant{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", job_id=" + job_id +
                ", status='" + status + '\'' +
                ", created_at=" + created_at +
                '}';
    }
}
