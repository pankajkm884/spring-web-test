package com.info.spring_web_test.controller;

import com.info.spring_web_test.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/users")
public class controller {

    List<User> users = new ArrayList<>();
    @Value("${database.username}")
    private String username;
    @Value("${database.password}")
    private String password;
    @Value("${database.url}")
    private String url;


    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody User user){
        System.out.println("this is testing site: from repository1");
        System.out.println("this is testing site: from local2");
        System.out.println("this is testing site");
        System.out.println("this is testing site");
        System.out.println("this is testing site");
        System.out.println("this is testing site");
        Optional<User> optionalUser = Optional.of(user);
        if(optionalUser.isPresent()){
            User user1 = new User();
            user.setId(user1.getId());
            users.add(user);
            return ResponseEntity.ok(user);

        }else{
            return new ResponseEntity("NO Content Exist", HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable("id") String id){
        User userContainer = null;
        for (User user: users){
            if(user.getId().equals(id)){
                userContainer = user;
                break;
            }
        }
        return new ResponseEntity(userContainer, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAllUser(){
        Map<String, Object> map = new HashMap<>();
        map.put("username", username);
        map.put("password", password);
        map.put("url", url);
        map.put("users", users);

        return new ResponseEntity(map, HttpStatus.OK);
    }

}
