package com.team4.ailearneye.repository;

import com.team4.ailearneye.entity.GeneratedSentence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeneratedSentenceRepository extends JpaRepository<GeneratedSentence, Long> {
}
