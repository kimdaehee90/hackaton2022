package com.example.gaegizo.domain.memo.service;

import com.example.gaegizo.domain.compareBox.domain.CompareBox;
import com.example.gaegizo.domain.compareBox.repository.CompareBoxRepository;
import com.example.gaegizo.exception.GaegizoException;
import com.example.gaegizo.domain.memo.domain.Memo;
import com.example.gaegizo.domain.memo.dto.MemoDto;
import com.example.gaegizo.domain.memo.repository.MemoRepository;
import com.example.gaegizo.domain.memo.dto.request.CreateMemoRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.example.gaegizo.exception.GaegizoErrorCode.COMPARE_BOX_NOT_FOUND;
import static com.example.gaegizo.exception.GaegizoErrorCode.MEMO_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class MemoService {

    private final CompareBoxRepository compareBoxRepository;
    private final MemoRepository memoRepository;

    @Transactional
    public Long createMemo(CreateMemoRequest request) {

        CompareBox compareBox = compareBoxRepository.findById(request.getCompareBoxId())
                .orElseThrow(() -> new GaegizoException(COMPARE_BOX_NOT_FOUND));
        Memo memo = Memo.builder()
                .compareBox(compareBox)
                .content(request.getContent())
                .build();
        return memoRepository.save(memo).getId();
    }

    @Transactional
    public Long updateMemo(Long memoId, String content) {
        Memo memo = memoRepository.findById(memoId)
                .orElseThrow(() -> new GaegizoException(MEMO_NOT_FOUND));
        return memo.update(content);
    }

    @Transactional
    public boolean deleteMemo(Long memoId) {
        Memo memo = memoRepository.findById(memoId)
                .orElseThrow(() -> new GaegizoException(MEMO_NOT_FOUND));
        memoRepository.delete(memo);
        return true;
    }

    public MemoDto getMemo(Long memoId) {

        Memo memo = memoRepository.findById(memoId)
                .orElseThrow(() -> new GaegizoException(MEMO_NOT_FOUND));
        return MemoDto.from(memo);
    }
}
