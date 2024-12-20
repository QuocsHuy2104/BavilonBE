package com.pearus.bavilonbe.repository;

import com.pearus.bavilonbe.entity.InvalidToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvalidatedTokenRepository extends JpaRepository<InvalidToken, String> {
}