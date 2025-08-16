package com.uijeong.microblog.member.exception;

/**
 * DB 에서 이메일이 일치하는 사용자를 찾을 수 없는 상황에 발생하는 예외
 */
public class EmailNotFoundException extends RuntimeException {

    public EmailNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
