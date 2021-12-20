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

    @Column
    @NotNull
    private String status;

    @Column(updatable = false)
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date created_at = new Date();

    public Applicant(Long user_id, Long job_id, String status) {
        this.user_id = user_id;
        this.job_id = job_id;
        this.status = status;
    }

    public Applicant(){
    }

    @PreUpdate
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
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
