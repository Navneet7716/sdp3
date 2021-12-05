package com.example.sdp3.Pojo;


import javax.persistence.*;

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
    private Long user_id;

    public Experience() {

    }

    public Long getId() {
        return id;
    }

    public Experience(Long id, String title, String duration, String location, Long user_id) {
        this.id = id;
        this.title = title;
        this.duration = duration;
        this.location = location;
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "Experience{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", duration='" + duration + '\'' +
                ", location='" + location + '\'' +
                ", user_id=" + user_id +
                '}';
    }

    public void setId(Long id) {
        this.id = id;
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
