package com.talentrecruit.talentrec.repository;

import com.talentrecruit.talentrec.pojo.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

public interface JobRepository extends JpaSpecificationExecutor<Job>, JpaRepository<Job, Integer> {
//        @Override
//        @Query(value = "select job.jobid, job.jobtype, job.jobname, job.salary, job.uid, userinfo.name from job join userinfo on job.uid = userinfo.uid", nativeQuery = true)
//        List<Map<String, Object>> findAll();
    @Query(value = "select * from job where uid=:u", nativeQuery = true)
    List<Map<String, Object>> getEnterpriseJob(@Param("u") Integer uid);

    @Transactional
    @Modifying
    @Query(value = "update job set enterprisename=:name where uid=:id", nativeQuery = true)
    Integer updateJobProviderName(@Param("id") Integer id, @Param("name") String name);


}
