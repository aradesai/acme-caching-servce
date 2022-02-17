package com.acme.cache.service.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.ExceptionTranslationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private PeopleWithNameOnLetterKAuthenticationProvider peopleWithNameOnLetterKAuthenticationProvider;

    @Override
    public void configure(AuthenticationManagerBuilder authManager) throws Exception {
        authManager
                .inMemoryAuthentication()
                .withUser("admin")
                .password(passwordEncoder().encode("admin1"))
                .roles("ADMIN", "USER")
                .and()
                .withUser("tester")
                .password(passwordEncoder().encode("abc"))
                .roles("USER");
        authManager.authenticationProvider(peopleWithNameOnLetterKAuthenticationProvider);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/admin-secure").hasRole("ADMIN")
                .antMatchers("/user-secure").hasRole("USER")
                .antMatchers("/**").permitAll()
                .and()
                .formLogin()
                .successForwardUrl("/secure");
        http.addFilterAfter(new CustomPractiseFilter(), ExceptionTranslationFilter.class);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
