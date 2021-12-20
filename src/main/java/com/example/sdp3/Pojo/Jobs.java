package com.example.sdp3.Pojo;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;


@Entity
@Table(name="jobs_table")
public class Jobs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Long id;


    @Column(name="job_title")
    @NotNull
    private String job_title;

    @Column(name="company")
    @NotNull
    private String company;

    @Column(name="workplace")
    @NotNull
    private String workplace;

    @Column(name="job_description")
    @NotNull
    private String job_description;

    @Column(name="job_location")
    @NotNull
    private String job_location;

    @Column(name="employment_type")
    @NotNull
    private String employment_type;

    @Column(nullable = false)
    private Long userId;


    @Column(updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date created_at = new Date();


    public Jobs(String job_title, String company, String workplace, String job_description, String job_location, String employment_type, Long user_id) {
        this.job_title = job_title;
        this.company = company;
        this.workplace = workplace;
        this.job_description = job_description;
        this.job_location = job_location;
        this.employment_type = employment_type;
        this.userId = user_id;
    }

    //No args constructor
    public Jobs() {

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

    public void setId(Long id) {
        this.id = id;
    }
    public Long getUser_id() {
        return this.userId;
    }

    public void setUser_id(Long user_id) {
        this.userId = user_id;
    }
    public String getJob_title() {
        return job_title;
    }

    public void setJob_title(String job_title) {
        this.job_title = job_title;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getWorkplace() {
        return workplace;
    }

    public void setWorkplace(String workplace) {
        this.workplace = workplace;
    }

    public String getJob_description() {
        return job_description;
    }

    public void setJob_description(String job_description) {
        this.job_description = job_description;
    }

    public String getJob_location() {
        return job_location;
    }

    public void setJob_location(String job_location) {
        this.job_location = job_location;
    }

    public String getEmployment_type() {
        return employment_type;
    }

    public void setEmployment_type(String employment_type) {
        this.employment_type = employment_type;
    }

    @Override
    public String toString() {
        return "Jobs{" +
                "id=" + id +
                ", job_title='" + job_title + '\'' +
                ", company='" + company + '\'' +
                ", workplace='" + workplace + '\'' +
                ", job_description='" + job_description + '\'' +
                ", job_location='" + job_location + '\'' +
                ", employment_type='" + employment_type + '\'' +
                ", user_id=" + userId +
                ", created_at=" + created_at +
                '}';
    }
}
