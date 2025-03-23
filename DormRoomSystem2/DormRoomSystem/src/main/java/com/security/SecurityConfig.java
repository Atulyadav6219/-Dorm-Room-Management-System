//package com.security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    @Bean
//    public BCryptPasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//            .authorizeHttpRequests(auth -> auth
//                .requestMatchers("/", "/signup", "/login", "/css/**").permitAll() // Public access
//                .anyRequest().authenticated() // All other pages need login
//            )
//            .formLogin(form -> form
//                .loginPage("/login") // Custom login page
//                .defaultSuccessUrl("/dashboard", true) // After login, go to dashboard
//                .permitAll()
//            )
//            .logout(logout -> logout
//                .logoutUrl("/logout") // Logout endpoint
//                .logoutSuccessUrl("/") // After logout, go to login
//                .permitAll()
//            )
//            .csrf().disable(); // CSRF off for POST requests
//
//        return http.build();
//    }
//}