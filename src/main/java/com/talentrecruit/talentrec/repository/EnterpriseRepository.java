package com.talentrecruit.talentrec.repository;


import com.talentrecruit.talentrec.pojo.Enterprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface EnterpriseRepository extends JpaRepository<Enterprise, Integer> {

    @Transactional
    @Modifying
    @Query(value = "insert into enterpriseuser (uid, valid) values(?1, 0)", nativeQuery = true)
    Integer InitEnterpriseuser(@Param("id") Integer id);


    @Query(value = "select valid from enterpriseuser where uid=:id", nativeQuery = true)
    Integer getValidById(@Param("id") Integer id);

    @Transactional
    @Modifying
    @Query(value = "update enterpriseuser set valid = 1 where uid=:id", nativeQuery = true)
    Integer setValid(@Param("id") Integer id);
//    @Transactional
//    @Modifying
//    @Query(value = "update enterpriseuser set name=?2 where idu.uid=?1", nativeQuery = true)
//    Integer updateUsername(@Param("id") Integer uid, @Param("uname") String name);
}
