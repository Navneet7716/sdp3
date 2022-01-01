package com.example.sdp3.Security.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

public interface UserDetailsServiceImpl2 extends UserDetailsService {
    @Transactional
    UserDetails loadUserByEmail(String email) throws UsernameNotFoundException;
}
