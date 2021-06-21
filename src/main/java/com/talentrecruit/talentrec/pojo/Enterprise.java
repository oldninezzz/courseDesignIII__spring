package com.talentrecruit.talentrec.pojo;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table( name = "enterpriseuser")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class Enterprise {

    @Id
    @Column(name = "uid")
    private Integer uid;

    @Column(name = "address")
    private String address;

    @Column(name = "valid")
    private Integer valid;

    @Column(name = "name")
    private String name;
}
