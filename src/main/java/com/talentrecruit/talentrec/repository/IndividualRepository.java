package com.talentrecruit.talentrec.repository;

import com.talentrecruit.talentrec.pojo.Individual;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface IndividualRepository extends JpaSpecificationExecutor<Individual>, JpaRepository<Individual, Integer> {

    @Transactional
    @Modifying
    @Query(value = "update individualuser idu set idu.name=?2 where idu.uid=?1", nativeQuery = true)
    Integer updateUsername(@Param("id") Integer uid, @Param("uname") String name);

    @Transactional
    @Modifying
    @Query(value = "insert into individualuser (uid, valid) values(?1, 0)", nativeQuery = true)
    Integer InitIndividualuser(@Param("id") Integer id);

    @Transactional
    @Modifying
    @Query(value = "update individualuser set valid = 1 where uid=:id", nativeQuery = true)
    Integer setValid(@Param("id") Integer id);

    @Query(value = "select valid from individualuser where uid=:id", nativeQuery = true)
    Integer getValidById(@Param("id") Integer id);

}
