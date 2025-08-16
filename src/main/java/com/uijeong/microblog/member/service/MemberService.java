package com.uijeong.microblog.member.service;

import com.uijeong.microblog.member.entity.Member;
import com.uijeong.microblog.member.exception.EmailNotFoundException;
import com.uijeong.microblog.member.repository.MemberRepository;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * 사용자 서비스
 */
@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    /**
     * 회원 가입 서비스
     */
    public Member register(String email, String password, String nickname, String profileImageUrl) {
        if (memberRepository.existsByNickname(nickname)) {
            throw new IllegalArgumentException("Nickname already exists");
        }
        if (memberRepository.existsByEmail(email)) {
            throw new IllegalArgumentException("Email already exists");
        }

        Member member = Member.builder()
            .email(email)
            .password(passwordEncoder.encode(password))
            .nickname(nickname)
            .profileImageUrl(profileImageUrl)
            .roles(Set.of("ROLE_USER"))
            .build();

        return memberRepository.save(member);
    }

    /**
     * 사용자 조회 서비스: Email 기반
     */
    public Member findByEmail(String email) {
        return memberRepository.findByEmail(email)
            .orElseThrow(() -> new EmailNotFoundException("User not found"));
    }
}
