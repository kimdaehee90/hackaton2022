package com.example.gaegizo.domain.memo.controller;

import com.example.gaegizo.domain.memo.dto.request.MemoCreateRequest;
import com.example.gaegizo.domain.memo.dto.response.MemoCreateResponse;
import com.example.gaegizo.domain.memo.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MemoController {

    private final MemoService memoService;

    @PostMapping("/create")
    public MemoCreateResponse createMemo(@RequestBody MemoCreateRequest request) {
        return new MemoCreateResponse(memoService.createMemo(request));
    }

//    @GetMapping("/getMemo")
//    public
}
