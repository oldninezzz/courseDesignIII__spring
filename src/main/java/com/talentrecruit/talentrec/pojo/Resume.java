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
@Table( name = "resume")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class Resume {

    @Id
    @Column(name = "uid")
    private Integer uid;

    @Column(name = "graduateschool")
    private String graduateschool;

    @Column(name = "workexperience")
    private String workexperience;

    @Column(name = "prize")
    private String prize;
}
