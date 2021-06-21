package com.talentrecruit.talentrec.repository;

import com.talentrecruit.talentrec.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

public interface UserinfoRepository extends JpaRepository<User, Integer> {

    @Query(value = "select uid, utype from userinfo where account=:acc and password=:pwd", nativeQuery = true)
    List<Map<String, Object>> getUidByAccount(@Param("acc") String account, @Param("pwd") String password);

//    @Query(value = "select * from individualuser")
    @Transactional
    @Modifying
    @Query(value = "update userinfo ui set ui.name=:uname where ui.uid=:id", nativeQuery = true)
    Integer updateUsername(@Param("id") Integer uid, @Param("uname") String name);

    @Query(value = "select password from userinfo where uid=:id", nativeQuery = true)
    String getPasswordById(@Param("id") Integer id);

    @Transactional
    @Modifying
    @Query(value = "update userinfo set password=:pwd where uid=:id", nativeQuery = true)
    Integer updatePassword(@Param("id") Integer id, @Param("pwd") String password);

}
