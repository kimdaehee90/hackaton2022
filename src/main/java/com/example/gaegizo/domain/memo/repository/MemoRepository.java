package com.example.gaegizo.domain.memo.repository;

import com.example.gaegizo.domain.memo.domain.Memo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemoRepository extends JpaRepository<Memo, Long> {
}
