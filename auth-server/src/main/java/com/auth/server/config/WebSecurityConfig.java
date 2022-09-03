package com.auth.server.config;

import com.auth.server.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {

    @Autowired
    UserDetailsServiceImpl userDetailsService;


    @Bean
    public SecurityFilterChain securityAuthFilterChain(HttpSecurity http) throws Exception{
        return http.cors().and().csrf().disable().formLogin()
                .and()
                .authorizeRequests()
                .antMatchers("/auth/register").permitAll()
                .anyRequest().authenticated()
                .and()
                .logout()
                .and()
                .build();
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}

