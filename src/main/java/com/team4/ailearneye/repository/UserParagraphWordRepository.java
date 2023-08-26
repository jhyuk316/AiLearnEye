package com.team4.ailearneye.repository;

import com.team4.ailearneye.entity.UserParagraphWord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserParagraphWordRepository extends JpaRepository<UserParagraphWord, Long> {

    Optional<UserParagraphWord> findByMemberIdAndWord(long memberId, String word);
}
