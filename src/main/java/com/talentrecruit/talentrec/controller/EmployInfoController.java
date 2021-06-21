package com.talentrecruit.talentrec.controller;

import com.talentrecruit.talentrec.pojo.EmployInfo;
import com.talentrecruit.talentrec.pojo.Job;
import com.talentrecruit.talentrec.repository.EmployInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class EmployInfoController {

    @Autowired
    EmployInfoRepository employInfoRepository;

    @PostMapping("/getEmployInfo")
    public List<Map<String, Object>> getEmployInfo(@RequestParam Integer uid){
        return employInfoRepository.getEmployInfoById(uid);
    }

    @PostMapping("/deleteEmployInfo")
    boolean deleteEmployInfo(@RequestParam Integer uid, Integer jobid){
        Integer i = employInfoRepository.deleteEmployInfoById(uid, jobid);
        return true;
    }

    @PostMapping("/addEmployInfo")
    boolean addEmployInfo(@RequestBody EmployInfo employInfo){
        employInfoRepository.save(employInfo);
        return true;
    }

}
