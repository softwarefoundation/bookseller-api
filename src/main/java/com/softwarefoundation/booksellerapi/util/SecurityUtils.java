package com.softwarefoundation.booksellerapi.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

@Slf4j
public class SecurityUtils {

    public static final String ROLE_PREFIX = "ROLE_";

    public static SimpleGrantedAuthority convertToAuthority(String role) {
        log.info("TRACKER: SimpleGrantedAuthority: {0}", role);
        String formattedRole = role.startsWith(ROLE_PREFIX) ? role : ROLE_PREFIX.concat(role);
        log.info("TRACKER: SimpleGrantedAuthority formattedRole: {0}", formattedRole);
        return new SimpleGrantedAuthority(formattedRole);
    }


}
