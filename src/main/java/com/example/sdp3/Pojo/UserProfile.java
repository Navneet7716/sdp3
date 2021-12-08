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
@Table(name = "user_profile")
@TypeDef(
        name = "list-array",
        typeClass = ListArrayType.class
)
public class UserProfile {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Long id;

    @Column
    @NotNull
    private Long user_id;


    @Column
    @Size(max = 250)
    private String bio;

    @Column
    @Size(max = 100)
    private String github_link;

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


    @Column
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date created_at = new Date();

    @PreUpdate
    public void setUpdatedAt() {
        this.created_at= new Date();
    }

    public UserProfile(){

    }
    public UserProfile(Long user_id, String bio, String github_link, String linkedIn_link, List<String> languages, List<String> skills, String profile_image) {
        this.user_id = user_id;
        this.bio = bio;
        this.github_link = github_link;
        this.linkedIn_link = linkedIn_link;
        this.languages = languages;
        this.skills = skills;
        this.profile_image = profile_image;
    }

    public Long getId() {
        return id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getBio() {
        return bio;
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
