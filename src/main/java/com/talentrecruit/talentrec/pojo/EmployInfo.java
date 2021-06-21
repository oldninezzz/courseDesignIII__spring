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
@Table(name = "jobinformation")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class EmployInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "jinfoid")
    private Integer jinfoid;

    @Column(name = "uid")
    private Integer uid;

    @Column(name = "jobid")
    private Integer jobid;

}
