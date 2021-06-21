package com.talentrecruit.talentrec.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "userinfo")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer uid;

    @Column(name = "name")
    private String name;
    @Column(name = "account")
    private String account;
    @Column(name = "password")
    private String password;
    @Column(name = "utype")
    private String utype;


}
