package com.talentrecruit.talentrec.repository;

import com.talentrecruit.talentrec.pojo.Membership;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface MembershipRepository extends JpaRepository<Membership, Integer> {

    @Transactional
    @Modifying
    @Query(value = "update membershipapplication set isdisposal = 1 where memshipid=:id", nativeQuery = true)
    Integer setDisposalTrue(@Param("id") Integer memshipid);


}
