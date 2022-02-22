package com.example.gaegizo.domain.interesetJob.repository;

import com.example.gaegizo.domain.interesetJob.domain.InterestJob;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InterestJobRepository extends JpaRepository<InterestJob, Long> {
    Optional<InterestJob> findByJobNumber(String jobNumber);
}
