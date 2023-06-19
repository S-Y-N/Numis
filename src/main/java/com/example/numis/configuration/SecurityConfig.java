package com.example.numis.configuration;

import com.example.numis.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private UserService _userService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/",
                                "/registration*",
                                "/login*",
                                "/css/**",
                                "/img/**")
                        .permitAll()
                        .anyRequest()
                        .authenticated()
                )
                .formLogin((form) -> {
                    form.loginPage("/login")
                            .defaultSuccessUrl("/home", true)
                            .failureUrl("/login-error")
                            .permitAll();
                })
                .logout((logout) -> {
                    logout.permitAll();
                })
                .userDetailsService(_userService);

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
