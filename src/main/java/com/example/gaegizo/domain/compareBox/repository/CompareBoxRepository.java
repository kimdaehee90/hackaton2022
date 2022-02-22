package com.example.gaegizo.domain.compareBox.repository;

import com.example.gaegizo.domain.compareBox.domain.CompareBox;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompareBoxRepository extends JpaRepository<CompareBox, Long> {
    Optional<CompareBox> findById(Long id);
}