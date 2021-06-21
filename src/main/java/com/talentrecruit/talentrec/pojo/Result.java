package com.talentrecruit.talentrec.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result implements Serializable {
    private boolean success = true;

    private Integer status;

    private String code;

    private String message;

    private Object data;

}
