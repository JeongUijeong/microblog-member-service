package com.uijeong.microblog.member.dto;

import com.uijeong.microblog.member.entity.Member;
import java.util.Set;
import lombok.Builder;

/**
 * 사용자 정보 응답 DTO
 *
 * @param id              사용자 식별자
 * @param email           이메일
 * @param password        암호화된 비밀번호
 * @param nickname        닉네임
 * @param profileImageUrl 프로필 이미지 URL
 * @param roles           역할 리스트
 */
@Builder
public record MemberResponse(
    Long id,
    String email,
    String password,
    String nickname,
    String profileImageUrl,
    Set<String> roles
) {

    public static MemberResponse from(Member member) {
        return MemberResponse.builder()
            .id(member.getId())
            .email(member.getEmail())
            .password(member.getPassword())
            .nickname(member.getNickname())
            .profileImageUrl(member.getProfileImageUrl())
            .roles(member.getRoles())
            .build();
    }
}
