package com.example.gaegizo.domain.memo.service;

import com.example.gaegizo.domain.compareBox.domain.CompareBox;
import com.example.gaegizo.domain.compareBox.repository.CompareBoxRepository;
import com.example.gaegizo.domain.memo.domain.Memo;
import com.example.gaegizo.domain.memo.repository.MemoRepository;
import com.example.gaegizo.domain.memo.dto.request.MemoCreateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemoService {

    private final CompareBoxRepository compareBoxRepository;
    private final MemoRepository memoRepository;

    @Transactional
    public Long createMemo(MemoCreateRequest request) {

        CompareBox compareBoxId = compareBoxRepository.findById(request.getCompareBoxId())
                .orElseThrow(() -> new RuntimeException()); //Todo: 예외처리
        Memo memo = Memo.builder()
                .compareBox(compareBoxId)
                .content(request.getContent())
                .build();
        return memoRepository.save(memo).getId();
    }
}
