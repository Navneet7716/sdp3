package com.example.sdp3.Pojo;


import javax.persistence.*;

@Entity
@Table(name = "education_table")
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Long id;

    @Column(nullable = false)
    private String institution_name;

    @Column()
    private String duration;

    @Column()
    private String location;

    @Column()
    private String degree_type;

    @Column()
    private Long user_id;

    public Education(Long id, String institution_name, String duration, String location, String degree_type, Long user_id) {
        this.id = id;
        this.institution_name = institution_name;
        this.duration = duration;
        this.location = location;
        this.degree_type = degree_type;
        this.user_id = user_id;
    }

    public Education() {
    }

    @Override
    public String toString() {
        return "Education{" +
                "id=" + id +
                ", institution_name='" + institution_name + '\'' +
                ", duration='" + duration + '\'' +
                ", location='" + location + '\'' +
                ", degree_type='" + degree_type + '\'' +
                ", user_id=" + user_id +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInstitution_name() {
        return institution_name;
    }

    public void setInstitution_name(String institution_name) {
        this.institution_name = institution_name;
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

    public String getDegree_type() {
        return degree_type;
    }

    public void setDegree_type(String degree_type) {
        this.degree_type = degree_type;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }
}
