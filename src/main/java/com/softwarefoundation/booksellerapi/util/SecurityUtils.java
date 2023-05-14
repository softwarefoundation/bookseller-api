package com.softwarefoundation.booksellerapi.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

@Slf4j
public class SecurityUtils {

    public static final String ROLE_PREFIX = "ROLE_";
    public static final String AUTH_HEADER = "authorization";
    public static final String AUTH_TOKEN_TYPE = "Bearer";
    public static final String AUTH_TOKEN_PREFIX = AUTH_TOKEN_TYPE.concat(" ");

    public static SimpleGrantedAuthority convertToAuthority(String role) {
        log.info("TRACKER: SimpleGrantedAuthority: {0}", role);
        String formattedRole = role.startsWith(ROLE_PREFIX) ? role : ROLE_PREFIX.concat(role);
        log.info("TRACKER: SimpleGrantedAuthority formattedRole: {0}", formattedRole);
        return new SimpleGrantedAuthority(formattedRole);
    }

    public static String extractAuthTokenFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader(AUTH_HEADER);
        if (!StringUtils.hasLength(bearerToken) && bearerToken.startsWith(AUTH_TOKEN_PREFIX)) {
            return bearerToken.substring(7);
        }
        return null;
    }


}
