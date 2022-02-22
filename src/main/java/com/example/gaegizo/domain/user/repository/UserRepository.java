package com.example.gaegizo.domain.user.repository;

import com.example.gaegizo.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

}
