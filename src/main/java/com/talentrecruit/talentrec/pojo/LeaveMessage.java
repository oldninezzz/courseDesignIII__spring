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
@Table(name = "leavingmessage")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class LeaveMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lmessageid")
    private Integer lmessageid;

    @Column(name = "leaverid")
    private Integer leaverid;

    @Column(name = "leavingcontent")
    private String leavingcontent;

    @Column(name = "isread")
    private Integer isread;

    @Column(name = "leavername")
    private String leavername;

}
