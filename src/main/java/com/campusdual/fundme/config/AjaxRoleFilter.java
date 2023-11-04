package com.campusdual.fundme.config;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AjaxRoleFilter extends OncePerRequestFilter {

    private static final String XML_HTTP_REQUEST = "XMLHttpRequest";
    private static final String AJAX_ROLE_HEADER = "X-User-Role";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        Authentication originalAuthentication = SecurityContextHolder.getContext().getAuthentication();

        if (isAjaxRequest(request)) {

            List<GrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority("AJAX_ROLE"));

            UsernamePasswordAuthenticationToken ajaxRoleAuthentication = new UsernamePasswordAuthenticationToken(
                    originalAuthentication.getPrincipal(),
                    originalAuthentication.getCredentials(),
                    authorities
            );

            SecurityContextHolder.getContext().setAuthentication(ajaxRoleAuthentication);

        }

        try {

            filterChain.doFilter(request, response);

        } finally {

            if (isAjaxRequest(request)) { SecurityContextHolder.getContext().setAuthentication(originalAuthentication); }

        }
    }

    private boolean isAjaxRequest(HttpServletRequest request) {

        return XML_HTTP_REQUEST.equals(request.getHeader("X-Requested-With"))  && "AJAX_ROLE".equals(request.getHeader(AJAX_ROLE_HEADER));
        
    }
}
