package com.team4.ailearneye.repository;

import com.team4.ailearneye.entity.UserWordHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserWordHistoryRepository extends JpaRepository<UserWordHistory, Long> {
    Optional<UserWordHistory> findByLiteracyIdAndQuizId(Long literacyId, Long quizId);

    List<UserWordHistory> findAllByLiteracyId(Long literacyId);
}
