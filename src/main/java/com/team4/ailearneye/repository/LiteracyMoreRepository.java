package com.team4.ailearneye.repository;

import com.team4.ailearneye.entity.LiteracyMore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LiteracyMoreRepository extends JpaRepository<LiteracyMore, Long> {

}
