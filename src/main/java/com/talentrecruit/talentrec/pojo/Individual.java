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
@Table( name = "individualuser")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class Individual {

    @Id
    @Column(name = "uid")
    private Integer uid;

    @Column(name = "usergender")
    private String usergender;

    @Column(name = "userage")
    private Integer userage;

    @Column(name = "valid")
    private Integer valid;

    @Column(name = "name")
    private String name;

}
