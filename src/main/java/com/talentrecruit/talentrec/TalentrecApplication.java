package com.talentrecruit.talentrec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
//@ServletComponentScan(basePackages = {"com/talentrecruit/talentrec/config/crosfilter.java"})
public class TalentrecApplication {

    public static void main(String[] args) {
        SpringApplication.run(TalentrecApplication.class, args);
    }

}
