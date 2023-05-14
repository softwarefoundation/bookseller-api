package com.softwarefoundation.booksellerapi.security;

import com.softwarefoundation.booksellerapi.model.User;
import com.softwarefoundation.booksellerapi.service.IUserService;
import com.softwarefoundation.booksellerapi.util.SecurityUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;

@Slf4j
@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private IUserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("TRACKER: loadUserByUsername : {0}", username);
        User user = userService.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username));
        Set<GrantedAuthority> authorities = Set.of(SecurityUtils.convertToAuthority(user.getRole().name()));
        return UserPrincipal.builder()
                .user(user)
                .username(username)
                .password(user.getPassword())
                .authorities(authorities)
                .build();
    }
}
