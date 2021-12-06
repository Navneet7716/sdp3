package com.example.sdp3.Pojo;

//Lincense PoJo


import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "user_license")
public class UserLicense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Long id;

    @Column
    @NotNull
    private Long user_id;


    @Column
    @Size(max = 100)
    private String license_name;

    @Column
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date received_date;

    @Column
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date expiration_date;

    @Column
    private String pdf_link;

    @Column
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date created_at = new Date();

    @PreUpdate
    public void setUpdatedAt() {
        this.created_at= new Date();
    }

    public UserLicense()
    {

    }

    public UserLicense(String license_name ,Date received_date , Date expiration_date , String pdf_link )
    {
        this.license_name = license_name;
        this.received_date = received_date;
        this.expiration_date = expiration_date;
        this.pdf_link = pdf_link;
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

    public String getLicense_name() {
        return license_name;
    }

    public void setLicense_name(String license_name) {
        this.license_name = license_name;
    }

    public Date getReceived_date() {
        return received_date;
    }

    public void setReceived_date(Date received_date) {
        this.received_date = received_date;
    }

    public Date getExpiration_date() {
        return expiration_date;
    }

    public void setExpiration_date(Date expiration_date) {
        this.expiration_date = expiration_date;
    }

    public String getPdf_link() {
        return pdf_link;
    }

    public void setPdf_link(String pdf_link) {
        this.pdf_link = pdf_link;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }
}
