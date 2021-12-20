package com.example.sdp3.Pojo;


import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Experience_table")
public class Experience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column()
    private String duration;

    @Column()
    private String location;

    @Column()
    private String description;


    @Column()
    private Long user_id;

    @Column(updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date created_at = new Date();

    public Experience() {

    }
    @PreUpdate
    public void setCreated_at() {
        this.created_at= new Date();
    }

    public Date getCreated_at() {
        return created_at;
    }

    public Long getId() {
        return id;
    }

    public Experience(String description,Long id, String title, String duration, String location, Long user_id) {
        this.id = id;
        this.title = title;
        this.duration = duration;
        this.location = location;
        this.user_id = user_id;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Experience{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", duration='" + duration + '\'' +
                ", location='" + location + '\'' +
                ", description='" + description + '\'' +
                ", user_id=" + user_id +
                ", created_at=" + created_at +
                '}';
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }
}
