package com.talentrecruit.talentrec.repository;

import com.talentrecruit.talentrec.pojo.Resume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ResumeRepository extends JpaRepository<Resume, Integer> {

    @Transactional
    @Modifying
    @Query(value = "insert into resume (uid) values(?1)", nativeQuery = true)
    Integer InitResume(@Param("id") Integer id);
}
