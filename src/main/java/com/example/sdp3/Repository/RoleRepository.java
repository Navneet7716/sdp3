package com.example.sdp3.Repository;

import java.util.Optional;

import com.example.sdp3.Pojo.ERole;
import com.example.sdp3.Pojo.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {
    Optional<Role> findByName(ERole name);
}