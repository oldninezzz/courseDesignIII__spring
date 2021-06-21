package com.talentrecruit.talentrec.controller;

import com.talentrecruit.talentrec.pojo.Token;
import com.talentrecruit.talentrec.pojo.User;
import com.talentrecruit.talentrec.repository.UserinfoRepository;
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
public class UserController {

    @Autowired
    UserinfoRepository userinfoRepository;

    @GetMapping("/getAllUser/{page}")
    public Page<User> getAllUser(@PathVariable("page") Integer page){
        Pageable pageable = PageRequest.of(page-1, 7);
        return userinfoRepository.findAll(pageable);
    }

    @PostMapping("/getUser")
    public User getUser(@RequestParam Integer uid){
        User user = userinfoRepository.getById(uid);
        return user;
    }

    @PostMapping("/getPasswordById")
    public String getPasswordById(@RequestParam Integer uid){
        return userinfoRepository.getPasswordById(uid);
    }

    @PostMapping("/updatePassword")
    public boolean updatePassword(@RequestParam Integer uid, String password){
        Integer i = userinfoRepository.updatePassword(uid, password);
        return true;
    }

    @PutMapping("/addUser")
    public Map<String, Object> addUser(@RequestBody User user){
        User saved;
        if(user.getUid() == null)
            saved = userinfoRepository.save(user);
        else{
            User user1 = userinfoRepository.getById(user.getUid());
            if(user1!=null){
                return null;
            }
            else{
                saved = userinfoRepository.save(user);
            }
        }
        String token = new Token().generateToken(user.getAccount());
        Map<String, Object> map1 = new HashMap<>();
        map1.put("utype", user.getUtype());
        map1.put("uid", saved.getUid());
        map1.put("token", token);
        return map1;
    }

    @PostMapping("/updateUser")
    public boolean updateUser(@RequestParam Integer uid, String name){
//        System.out.println(user);
        Integer i = userinfoRepository.updateUsername(uid, name);
        System.out.println(uid);
        System.out.println(name);
        return true;
    }


    @PostMapping("/loginCheck")
    public Map<String, Object> loginCheck(@RequestBody Map<String, Object> map){
//        System.out.println(map);
        String account = map.get("account").toString();
        String password = map.get("password").toString();
//        System.out.println(account+password);
        List<Map<String, Object>> umap = new ArrayList<>();
        umap = userinfoRepository.getUidByAccount(account, password);
        if(umap.size()>0){
            String token = new Token().generateToken(account);
            Map<String, Object> map1 = new HashMap<>();
            map1.put("utype", umap.get(0).get("utype"));
            map1.put("uid", umap.get(0).get("uid"));
            map1.put("token", token);
            return map1;
        }
        else{
            return null;
        }
    }

}
