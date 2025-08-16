package com.uijeong.microblog.member.controller;

import com.uijeong.microblog.member.dto.MemberResponse;
import com.uijeong.microblog.member.entity.Member;
import com.uijeong.microblog.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 내부 호출용 사용자 API 컨트롤러
 */
@RestController
@RequestMapping("/internal/members")
@RequiredArgsConstructor
public class MemberInternalController {

    private final MemberService memberService;

    /**
     * 회원 조회 API: Email 기반
     */
    @GetMapping
    public ResponseEntity<MemberResponse> getMember(@RequestParam String email) {
        Member member = memberService.findByEmail(email);
        return ResponseEntity.ok(MemberResponse.from(member));
    }
}

