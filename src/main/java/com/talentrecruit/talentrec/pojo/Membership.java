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
@Table( name = "membershipapplication")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class Membership {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "memshipid")
    private Integer memshipid;

    @Column(name = "uid")
    private Integer uid;

    @Column(name = "isdisposal")
    private Integer isdisposal;

    @Column(name = "account")
    private String account;

}
