package com.talentrecruit.talentrec.controller;


import com.talentrecruit.talentrec.pojo.JobInformation;
import com.talentrecruit.talentrec.repository.JobInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JobInformationController {

    @Autowired
    JobInformationRepository jobInformationRepository;

    @PostMapping("/getJobInformation")
    public List<JobInformation> getJobInformation(@RequestParam Integer uid){
        return jobInformationRepository.getJobInformationById(uid);
    }

    @PostMapping("/deleteJobInformationById")
    public boolean deleteJobInformationById(@RequestParam Integer jinfoid){
        jobInformationRepository.deleteById(jinfoid);
        return true;
    }

    @PostMapping("/deleteJobInformationByJobId")
    public boolean deleteJobInformationByJobId(@RequestParam Integer jobid){
        jobInformationRepository.deleteJobInformationByJobId(jobid);
        return true;
    }

}
