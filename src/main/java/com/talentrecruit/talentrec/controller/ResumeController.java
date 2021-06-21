package com.talentrecruit.talentrec.controller;

import com.talentrecruit.talentrec.pojo.Resume;
import com.talentrecruit.talentrec.repository.ResumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ResumeController {

    @Autowired
    ResumeRepository resumeRepository;

    @PostMapping ("/getResume")
    public Resume getResume(@RequestParam Integer uid){
//        Resume resume = resumeRepository.findById(uid).get();
//        return resume;
        Resume resume = new Resume();
        resume.setUid(uid);
        Example<Resume> example = Example.of(resume);
        Optional<Resume> optional = resumeRepository.findOne(example);
        return optional.isPresent() ? optional.get(): null;
    }

    @PutMapping("/updateResume")
    public boolean updateResume(@RequestBody Resume resume){
        resumeRepository.save(resume);
        return true;
    }

    @PostMapping("/initResume")
    public boolean initResume(@RequestParam Integer uid){
        Integer i = resumeRepository.InitResume(uid);
        return true;
    }

}
