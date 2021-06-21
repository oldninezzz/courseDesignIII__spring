package com.talentrecruit.talentrec.pojo;

import lombok.Data;

@Data
public class Token {
    private String token;

    public String generateToken(String account){
        return account+account.toUpperCase();
    }

}
