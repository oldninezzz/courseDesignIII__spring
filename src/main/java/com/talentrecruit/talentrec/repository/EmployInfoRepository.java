package com.talentrecruit.talentrec.repository;

import com.talentrecruit.talentrec.pojo.EmployInfo;
import com.talentrecruit.talentrec.pojo.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

public interface EmployInfoRepository extends JpaRepository<EmployInfo, Integer> {

    @Query(value = "select * from job where jobid in (select jobid from jobinformation where uid=:id)", nativeQuery = true)
    List<Map<String,Object>> getEmployInfoById(@Param("id") Integer id);


    @Transactional
    @Modifying
    @Query(value = "delete from jobinformation where jobid=:jid and uid=:id", nativeQuery = true)
    Integer deleteEmployInfoById(@Param("id") Integer id, @Param("jid") Integer jobid);
}
