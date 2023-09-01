package com.team4.ailearneye.repository;

import com.team4.ailearneye.entity.FavoriteSentence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavoriteSentenceRepository extends JpaRepository<FavoriteSentence, Long> {

    @Query("SELECT m FROM FavoriteSentence m WHERE m.paragraphId = :paragraphId OR m.paragraphId is null")
    List<FavoriteSentence> findAllByParagraphId(long paragraphId);

}
