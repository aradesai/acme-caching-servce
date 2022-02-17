package com.acme.cache.service.security;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class CustomPractiseFilter extends GenericFilterBean {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String webExplorer = ((HttpServletRequest) servletRequest).getHeader("User-Agent");
        if (webExplorer.contains("Edge")){
            //not logically correct, just for tests
            throw new BadCredentialsException("Edge is forbidden!");
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
