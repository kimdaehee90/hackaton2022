package com.example.gaegizo.domain.memo.controller;

import com.example.gaegizo.domain.memo.dto.request.CreateMemoRequest;
import com.example.gaegizo.domain.memo.dto.request.UpdateMemoRequest;
import com.example.gaegizo.domain.memo.dto.response.GetMemoResponse;
import com.example.gaegizo.domain.memo.dto.response.MemoCreateResponse;
import com.example.gaegizo.domain.memo.dto.response.UpdateMemoResponse;
import com.example.gaegizo.domain.memo.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MemoController {

    private final MemoService memoService;

    @PostMapping("/create")
    public MemoCreateResponse createMemo(@RequestBody CreateMemoRequest request) {
        return new MemoCreateResponse(memoService.createMemo(request));
    }

    @GetMapping("/getMemo/{memoId}")
    public GetMemoResponse getMemo(@PathVariable Long memoId) {
        return new GetMemoResponse(memoService.getMemo(memoId));
    }

    @PutMapping("/updateMemo/{memoId}")
    public UpdateMemoResponse updateMemo(@PathVariable Long memoId, @RequestBody UpdateMemoRequest request) {
        return new UpdateMemoResponse(memoService.updateMemo(memoId, request.getContent()));
    }

    @DeleteMapping("/deleteMemo/{memoId}")
    public boolean deleteMemo(@PathVariable Long memoId) {
        return memoService.deleteMemo(memoId);
    }
}
