package com.example.sdp3.Pojo;


import com.vladmihalcea.hibernate.type.array.ListArrayType;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
@Table
@TypeDef(
        name = "list-array",
        typeClass = ListArrayType.class
)
public class UserProfile {


    @Id
    @Column()
    private Long id;

    @Column
    @NotNull
    private Long userId;

    @Column()
    private String fullname;


    @Column
    @Size(max = 250)
    private String bio;

    @Column
    @Size(max = 100)
    private String github_link;

    @Column
    @Size(max = 100)
    private String resumeLink;

    @Column
    @Size(max = 100)
    private String linkedIn_link;


    @Type(type = "list-array")
    @Column(
            columnDefinition = "text[]"
    )
    private List<String> languages;

    @Type(type = "list-array")
    @Column(
            columnDefinition = "text[]"
    )
    private List<String> skills;


    @Column
    @Size(max = 1000)
    private String profile_image;

    @Transient
    private boolean isFollowing;


    @Column(updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date created_at = new Date();


    public UserProfile(){

    }
    public UserProfile(Long id,boolean isFollowing,String fullname,Long user_id, String bio, String github_link, String linkedIn_link, List<String> languages, List<String> skills, String profile_image, String resumeLink) {
        this.id = id;
        this.userId = user_id;
        this.fullname = fullname;
        this.bio = bio;
        this.github_link = github_link;
        this.linkedIn_link = linkedIn_link;
        this.languages = languages;
        this.skills = skills;
        this.profile_image = profile_image;
        this.resumeLink = resumeLink;
        this.isFollowing = isFollowing;
    }

    public boolean isFollowing() {
        return isFollowing;
    }

    public void setFollowing(boolean following) {
        isFollowing = following;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Long getId() {
        return id;
    }

    public Long getUser_id() {
        return userId;
    }

    public void setUser_id(Long user_id) {
        this.userId = user_id;
    }

    public String getBio() {
        return bio;
    }

    public String getResumeLink() {
        return resumeLink;
    }

    public void setResumeLink(String resumeLink) {
        this.resumeLink = resumeLink;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGithub_link() {
        return github_link;
    }

    public void setGithub_link(String github_link) {
        this.github_link = github_link;
    }

    public String getLinkedIn_link() {
        return linkedIn_link;
    }

    public void setLinkedIn_link(String linkedIn_link) {
        this.linkedIn_link = linkedIn_link;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public String getProfile_image() {
        return profile_image;
    }

    public void setProfile_image(String profile_image) {
        this.profile_image = profile_image;
    }








}
