package com.talentrecruit.talentrec.repository;

import com.talentrecruit.talentrec.pojo.JobInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface JobInformationRepository extends JpaRepository<JobInformation, Integer> {

    @Query(value = "select * from jobinformation where uid=:id", nativeQuery = true)
    List<JobInformation> getJobInformationById(@Param("id") Integer id);

    @Transactional
    @Modifying
    @Query(value = "delete from jobinformation where jobid=:jid", nativeQuery = true)
    Integer deleteJobInformationByJobId(@Param("jid") Integer jid);

}
