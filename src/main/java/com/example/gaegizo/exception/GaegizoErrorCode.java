package com.example.gaegizo.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum GaegizoErrorCode {

    COMPARE_BOX_NOT_FOUND("해당 공고 박스를 찾지 못했습니다."),
    MEMO_NOT_FOUND("메모장을 찾지 못했습니다."),
    JOB_NUMBER_NOT_FOUND_EXCEPTION("해당 공고를 찾지 못했습니다."),
    USER_NOT_FOUND_EXCEPTION("사용자를 찾지 못했습니다.");
    private final String message;
}
