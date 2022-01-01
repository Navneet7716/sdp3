package com.example.sdp3.Pojo;


import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="projects_table")
public class Projects {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Long id;


    @Column(nullable = false)
    private String name;

    @Column(length = 10000)
    private String git_link;

    @Column(length = 400)
    private String description;

    @Column()
    private Long user_id;

    @Column()
    private String duration;

    @Column(updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date created_at = new Date();

    @PreUpdate
    public void setCreated_at() {
        this.created_at= new Date();
    }

    public Date getCreated_at() {return this.created_at;}


    public Projects(Long id, String name, String git_link, String description, Long user_id, String duration) {
        this.id = id;
        this.name = name;
        this.git_link = git_link;
        this.description = description;
        this.user_id = user_id;
        this.duration = duration;
    }

    public Long getId() {
        return id;
    }

    public Projects() {
    }

    @Override
    public String toString() {
        return "Projects{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", git_link='" + git_link + '\'' +
                ", description='" + description + '\'' +
                ", user_id=" + user_id +
                ", duration='" + duration + '\'' +
                ", created_at=" + created_at +
                '}';
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGit_link() {
        return git_link;
    }

    public void setGit_link(String git_link) {
        this.git_link = git_link;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }
}
