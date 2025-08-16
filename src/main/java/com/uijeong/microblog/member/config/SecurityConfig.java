package com.uijeong.microblog.member.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Security 설정 클래스
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    /**
     * Security 필터 체인 (최소한의 설정)
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
            // CSRF(Cross-Site Request Forgery) 보호 비활성화(토큰 기반 인증 사용할 것)
            .csrf(AbstractHttpConfigurer::disable)
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/internal/**").permitAll() // 내부 호출은 인증 X
                .requestMatchers(HttpMethod.POST, "/api/members").permitAll() // 회원가입은 인증 X
                .anyRequest().authenticated()
            )
            .build();
    }

    /**
     * 비밀번호 암호화
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
