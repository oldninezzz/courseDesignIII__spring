package com.talentrecruit.talentrec.controller;

import com.talentrecruit.talentrec.pojo.LeaveMessage;
import com.talentrecruit.talentrec.pojo.Membership;
import com.talentrecruit.talentrec.repository.MembershipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MembershipController {

    @Autowired
    MembershipRepository membershipRepository;

    @GetMapping("/getAllMemApplication")
    public List<Membership> getAllMemApplication(){
        return membershipRepository.findAll();
    }

    @PostMapping("/deleteMemApplication")
    public boolean deleteMemApplication(@RequestParam Integer memshipid){
        membershipRepository.deleteById(memshipid);
        return true;
    }

    @PostMapping("/setDisposal")
    public boolean setDisposal(@RequestParam Integer memshipid){
        Integer i = membershipRepository.setDisposalTrue(memshipid);
        return true;
    }

    @PostMapping("/addMemApplication")
    public boolean addMessage(@RequestBody Membership membership){
        membershipRepository.save(membership);
        return true;
    }

}
