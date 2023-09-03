package com.team4.ailearneye.repository;

import com.team4.ailearneye.entity.UserWordMoreHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserWordMoreHistoryRepository extends JpaRepository<UserWordMoreHistory, Long> {
    Optional<UserWordMoreHistory> findByLiteracyIdAndQuizId(Long literacyId, Long quizId);

    List<UserWordMoreHistory> findAllByLiteracyId(Long literacyId);
}
