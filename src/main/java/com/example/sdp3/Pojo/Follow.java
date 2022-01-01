package com.example.sdp3.Pojo;


import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name= "follow_table")
public class Follow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Long id;


    @Column(nullable = false)
    private Long sourceUserid;

    @Column(nullable = false)
    private Long targetUserid;

    @Column(updatable = false)
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date created_at = new Date();

    public Follow() {

    }

    @PreUpdate
    public void setCreated_at() {
        this.created_at= new Date();
    }

    public Date getCreated_at() {
        return created_at;
    }

    public Follow(Long id, Long source_userid, Long target_userid) {
        this.id = id;
        this.sourceUserid = source_userid;
        this.targetUserid = target_userid;
    }

    @Override
    public String toString() {
        return "Follow{" +
                "id=" + id +
                ", source_userid=" + sourceUserid +
                ", target_userid=" + targetUserid +
                ", created_at=" + created_at +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSource_userid() {
        return sourceUserid;
    }

    public void setSource_userid(Long source_userid) {
        this.sourceUserid = source_userid;
    }

    public Long getTarget_userid() {
        return targetUserid;
    }

    public void setTarget_userid(Long target_userid) {
        this.targetUserid = target_userid;
    }
}
