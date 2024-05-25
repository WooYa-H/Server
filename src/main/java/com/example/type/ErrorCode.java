package com.example.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    COMPANY_NAME_DUPLICATED("회사명이 이미 존재합니다");

    private final String Description;
}
