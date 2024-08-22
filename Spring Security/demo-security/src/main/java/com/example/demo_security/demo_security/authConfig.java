package com.example.demo_security.demo_security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class authConfig {


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder ();
    }
    @Bean
    public UserDetailsService userDetailsService () {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("chahat")
                .password(passwordEncoder().encode("chahat10"))
                .roles("studentRole")
                .build());

        manager.createUser(User.withUsername("adarsh")
                .password(passwordEncoder().encode("adarsh23"))
                .roles("adminRole")
                .build());

        return manager;
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .httpBasic(Customizer.withDefaults())
                .authorizeHttpRequests((authorize) -> authorize.requestMatchers("/admin**").hasRole("adminRole")
                .requestMatchers("/student**").hasAnyRole("studentRole", "adminRole")
                .requestMatchers("/**").permitAll());
        http.formLogin(Customizer.withDefaults());
        return http.build();
    }
}

