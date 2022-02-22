package com.example.gaegizo.interesetJob.domain.InterestJob;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InterestJobRepository extends JpaRepository<InterestJob, Long> {
    Optional<InterestJob> findByjobNumber(String jobNumber);
}
