package com.example.sdp3.Pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(	name = "users",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "username"),
                @UniqueConstraint(columnNames = "email")
        })
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Long id;

    @Column
    @NotBlank
    @Size(max = 20)
    private String first_name;

    @Column
    @NotBlank
    @Size(max = 20)
    private String last_name;

    @Column
    @NotBlank
    @Size(max = 20)
    private String username;

    @Column
    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    @Column
    @NotBlank
    @Size(max = 120)
    private String password;


    @Column
    @NotBlank
    @Size(max = 10)
    private String gender;


    @Column
    @NotBlank
    @Pattern(regexp="(^$|[0-9]{10})")
    private Long phone;


    @Column
    @NotBlank
    @Size(max = 120)
    private String address;

    @Column(updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date created_at = new Date();

    @PreUpdate
    public void setUpdatedAt() {
        this.created_at= new Date();
    }



    public User() {
    }

    public User(String first_name , String last_name ,String username, String email,String password,String gender,Long phone, String address) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.gender  = gender;
        this.phone = phone;
        this.address = address;
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinTable(	name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public Long getId() {
        return id;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getCreated_at() {
        return created_at;
    }
    public String getLast_name() {
        return last_name;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
