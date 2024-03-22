package com.example.ngay22thang3.Controller;

import com.example.ngay22thang3.Entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController

public class UserT{
    private final List<User> userList;

    public UserT(List<User> userList){
        this.userList = userList;
    }

    @GetMapping("/user")
    public List<User> getUsers() {
        return userList;
    }
}
