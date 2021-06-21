package com.talentrecruit.talentrec.controller;

import com.talentrecruit.talentrec.pojo.Individual;
import com.talentrecruit.talentrec.pojo.Job;
import com.talentrecruit.talentrec.pojo.User;
import com.talentrecruit.talentrec.repository.IndividualRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class IndividualUser {

    @Autowired
    IndividualRepository individualRepository;

    @GetMapping("/getAllIndividual/{page}")
    public Page<Individual> getAllIndividual(@PathVariable("page") Integer page){
        Pageable pageable = PageRequest.of(page-1, 7);
        return individualRepository.findAll(pageable);
    }

    @PostMapping("/getIndiValid")
    public Map<String, Object> getValid(@RequestParam Integer uid){
        Integer valid = individualRepository.getValidById(uid);
        Map<String, Object> map = new HashMap<>();
        map.put("valid", valid);
        return map;
    }

    @PostMapping("/setIndiValid")
    public boolean setValid(@RequestParam Integer uid){
        Integer valid = individualRepository.setValid(uid);
        return true;
    }

    @PostMapping("/getIndividual")
    public Individual getIndividual(@RequestParam Integer uid){
        Individual individual = individualRepository.findById(uid).get();
        return individual;
    }

    @GetMapping("/searchIndiInfo/{page}/{keyword}")
    public Page<Individual> searchIndiInfo(@PathVariable("page") Integer page, @PathVariable("keyword") String keyword){
        Pageable pageable = PageRequest.of(page-1, 7);
        Specification<Individual> spec = new Specification<Individual>() {
            @Override
            public Predicate toPredicate(Root<Individual> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Path<String> usergender = root.get("usergender");
                Path<String> name = root.get("name");
                Predicate p1 = criteriaBuilder.like(usergender, "%"+keyword+"%");
                Predicate p2 = criteriaBuilder.like(name, "%"+keyword+"%");
                Predicate p = criteriaBuilder.or(p1, p2);
                return p;
            }
        };
        return individualRepository.findAll(spec, pageable);
    }


    @PostMapping("/updateIndividual")
    public boolean updateIndividual(@RequestBody Individual individual){
//        System.out.println(user);
//        System.out.println(uid);
//        System.out.println(name);
//        Integer i = individualRepository.updateUsername(uid, name);
        individualRepository.save(individual);
        return true;
    }

    @PostMapping("/initIndividual")
    public boolean initIndividual(@RequestParam Integer uid){
        Integer i = individualRepository.InitIndividualuser(uid);
        return true;
    }

}
