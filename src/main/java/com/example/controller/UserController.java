package com.example.controller;

import com.example.bean.User;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping(path="/add")
    public @ResponseBody String addNewUser (@RequestParam String name, @RequestParam String password){
        User u = new User();
        u.setName(name);
        u.setPassword(password);
        userRepository.save(u);
        return "\n *** Saved User***\n";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<User>getAllUsers() { return userRepository.findAll(); }

}