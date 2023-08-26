package com.team4.ailearneye.repository;

import com.team4.ailearneye.entity.Literacy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LiteracyRepository extends JpaRepository<Literacy, Long> {

}
