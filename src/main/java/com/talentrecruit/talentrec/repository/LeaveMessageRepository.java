package com.talentrecruit.talentrec.repository;

import com.talentrecruit.talentrec.pojo.LeaveMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface LeaveMessageRepository extends JpaRepository<LeaveMessage, Integer> {

    @Transactional
    @Modifying
    @Query(value = "update leavingmessage set isread=1 where lmessageid=:id", nativeQuery = true)
    Integer setIsRead(@Param("id") Integer lmessageid);

    @Transactional
    @Modifying
    @Query(value = "update leavingmessage set isread=0 where lmessageid=:id", nativeQuery = true)
    Integer setUnRead(@Param("id") Integer lmessageid);

}
