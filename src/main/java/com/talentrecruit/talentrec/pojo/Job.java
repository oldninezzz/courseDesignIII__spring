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
@Table( name = "job")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "jobid")
    private Integer jobid;

    @Column(name = "jobtype")
    private String jobtype;

    @Column(name = "jobname")
    private String jobname;

    @Column(name = "salary")
    private Float salary;

    @Column(name = "uid")
    private Integer uid;

    @Column(name = "enterprisename")
    private String enterprisename;

}
