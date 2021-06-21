package com.talentrecruit.talentrec.controller;

import com.talentrecruit.talentrec.pojo.Job;
import com.talentrecruit.talentrec.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.*;
import java.util.List;
import java.util.Map;

@RestController
public class JobController {

    @Autowired
    JobRepository jobRepository;

    @GetMapping("/getAllJob/{page}")
    public Page<Job> getAllJob(@PathVariable("page") Integer page){
        Pageable pageable = PageRequest.of(page-1, 7);
        return jobRepository.findAll(pageable);
    }

    @PostMapping("/getEnterpriseJob")
    public List<Map<String, Object>> getEnterpriseJob(@RequestParam Integer uid){
        return jobRepository.getEnterpriseJob(uid);
    }

    @PostMapping("/getJob")
    public Job getJob(@RequestParam Integer jobId){
        Job job = jobRepository.getById(jobId);
        return job;
    }

    @GetMapping("/searchJobInfo/{page}/{keyword}")
    public Page<Job> searchJobInfo(@PathVariable("page") Integer page, @PathVariable("keyword") String keyword){
        Pageable pageable = PageRequest.of(page-1, 7);
        Specification<Job> spec = new Specification<Job>() {
            @Override
            public Predicate toPredicate(Root<Job> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Path<String> jobname = root.get("jobname");
                Path<String> jobtype = root.get("jobtype");
                Predicate p1 = criteriaBuilder.like(jobname, "%"+keyword+"%");
                Predicate p2 = criteriaBuilder.like(jobtype, "%"+keyword+"%");
                Predicate p = criteriaBuilder.or(p1, p2);
                return p;
            }
        };
        return jobRepository.findAll(spec, pageable);
    }

    @PostMapping("/addJob")
    public boolean addJob(@RequestBody Job job){
        System.out.println(job);
        jobRepository.save(job);
        return true;
    }

    @PostMapping("/updateJob")
    public boolean updateJob(@RequestBody Job job){
        jobRepository.save(job);
        return true;
    }

    @PostMapping("/updateJobProviderName")
    public boolean updateJobProviderName(@RequestParam Integer uid, String name){
        Integer i = jobRepository.updateJobProviderName(uid, name);
        return true;
    }

    @PostMapping("/deleteJob")
    public boolean deleteJob(@RequestParam Integer jobId){
        jobRepository.deleteById(jobId);
        return true;
    }

}
