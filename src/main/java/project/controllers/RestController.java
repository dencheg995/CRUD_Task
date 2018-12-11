package project.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import project.module.User;
import project.service.UserService;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    private UserService userServiceDB;


    @GetMapping("/list")
    public List<User> list() {
        return userServiceDB.listUser();
    }
}
