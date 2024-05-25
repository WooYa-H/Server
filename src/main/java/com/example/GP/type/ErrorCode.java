package com.example.GP.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    COMPANY_NAME_DUPLICATED("회사명이 이미 존재합니다"),
    COMPANY_NOT_FOUND("회사를 찾을 수 없습니다.");

    private final String Description;
}
