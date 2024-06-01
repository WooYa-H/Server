package com.example.GP.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    COMPANY_NAME_DUPLICATED("회사명이 이미 존재합니다"),
    COMPANY_NOT_FOUND("회사를 찾을 수 없습니다."),
    DEPARTMENT_NOT_FOUND("부서를 찾을 수 없습니다."),
    DEPARTMENT_NAME_DUPLICATED("부서명이 이미 존재합니다"),
    USER_NOT_FOUND("회원을 찾을 수 없습니다"),
    USER_DUPLICATED("회원이 이미 존재합니다"),
    BUSINESS_NOT_FOUND("사업을 찾을 수 없습니다"),
    BUSINESS_NAME_DUPLICATED("사업명이 이미 존재합니다"),
    TEAM_NAME_DUPLICATED("팀명이 이미 존재합니다."),
    TEAM_NOT_FOUND("팀을 찾을 수 없습니다"),
    INVALID_REQUEST("잘못된 요청입니다."),
    INTERNAL_SERVER_ERROR("내부 서버 오류가 발생했습니다.");

    private final String Description;
}
