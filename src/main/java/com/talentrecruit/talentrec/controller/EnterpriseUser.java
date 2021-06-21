package com.talentrecruit.talentrec.controller;

import com.talentrecruit.talentrec.pojo.Enterprise;
import com.talentrecruit.talentrec.repository.EnterpriseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class EnterpriseUser {

    @Autowired
    EnterpriseRepository enterpriseRepository;

    @GetMapping("/getAllEnterprise/{page}")
    public Page<Enterprise> getAllEnterprise(@PathVariable("page") Integer page){
        Pageable pageable = PageRequest.of(page-1, 7);
        return enterpriseRepository.findAll(pageable);
    }

    @PostMapping("/getEnterprise")
    public Enterprise getEnterprise(@RequestParam Integer uid){
        Enterprise enterprise = enterpriseRepository.getById(uid);
        return enterprise;
    }

    @PostMapping("/setEnterValid")
    public boolean setValid(@RequestParam Integer uid){
        Integer valid = enterpriseRepository.setValid(uid);
        return true;
    }

    @PostMapping("/getEnterValid")
    public Map<String, Object> getValid(@RequestParam Integer uid){
        Integer valid = enterpriseRepository.getValidById(uid);
        Map<String, Object> map = new HashMap<>();
        map.put("valid", valid);
        return map;
    }

    @PostMapping("/initEnterprise")
    public boolean initResume(@RequestParam Integer uid){
        Integer i = enterpriseRepository.InitEnterpriseuser(uid);
        return true;
    }

    @PostMapping("/updateEnterprise")
    public boolean updateEnterprise(@RequestBody Enterprise enterprise){
        enterpriseRepository.save(enterprise);
        return true;
    }

}
