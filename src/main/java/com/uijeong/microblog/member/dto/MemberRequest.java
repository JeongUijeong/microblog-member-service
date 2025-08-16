package com.uijeong.microblog.member.dto;

/**
 * 회원 가입 요청 DTO
 *
 * @param email 이메일
 * @param password 비밀번호
 * @param nickname 닉네임
 * @param profileImageUrl 프로필 이미지 URL
 */
public record MemberRequest(
    String email,
    String password,
    String nickname,
    String profileImageUrl
) {

}
