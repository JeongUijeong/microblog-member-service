package com.uijeong.microblog.member.controller;

import com.uijeong.microblog.member.dto.MemberRequest;
import com.uijeong.microblog.member.dto.MemberResponse;
import com.uijeong.microblog.member.entity.Member;
import com.uijeong.microblog.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 사용자 API 컨트롤러
 */
@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    /**
     * 회원 가입 API
     */
    @PostMapping
    public ResponseEntity<MemberResponse> register(@RequestBody MemberRequest req) {
        Member member = memberService.register(req.email(), req.password(), req.nickname(), req.profileImageUrl());
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(MemberResponse.from(member));
    }

    /**
     * 회원 조회 API: Email 기반
     */
    @GetMapping("/{email}")
    public ResponseEntity<MemberResponse> getMember(@PathVariable String email) {
        Member member = memberService.findByEmail(email);
        return ResponseEntity.ok(MemberResponse.from(member));
    }
}

