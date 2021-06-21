package com.talentrecruit.talentrec.controller;

import com.talentrecruit.talentrec.pojo.LeaveMessage;
import com.talentrecruit.talentrec.repository.LeaveMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LeaveMessageController {

    @Autowired
    LeaveMessageRepository leaveMessageRepository;

    @GetMapping("/getAllLeaveMessage")
    public List<LeaveMessage> getAllLeaveMessage(){
        return leaveMessageRepository.findAll();
    }


    @PostMapping("/addMessage")
    public boolean addMessage(@RequestBody LeaveMessage leaveMessage){
        leaveMessageRepository.save(leaveMessage);
        return true;
    }

    @PostMapping("/setIsRead")
    public boolean setIsRead(@RequestParam Integer lmessageid){
        Integer i = leaveMessageRepository.setIsRead(lmessageid);
        return true;
    }

    @PostMapping("/setUnRead")
    public boolean setUnRead(@RequestParam Integer lmessageid){
        Integer i = leaveMessageRepository.setUnRead(lmessageid);
        return true;
    }

    @PostMapping("/deleteMessage")
    public boolean deleteMessage(@RequestParam Integer lmessageid){
        leaveMessageRepository.deleteById(lmessageid);
        return true;
    }

}
