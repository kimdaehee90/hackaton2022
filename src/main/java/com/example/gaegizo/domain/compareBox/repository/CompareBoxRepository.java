package com.example.gaegizo.domain.compareBox.repository;

import com.example.gaegizo.domain.compareBox.domain.CompareBox;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CompareBoxRepository extends JpaRepository<CompareBox, Long> {


    List<CompareBox> findByUser_Id(Long userId);

}

