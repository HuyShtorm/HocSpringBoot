package com.example.ngay29thang3.service;

import com.example.ngay29thang3.Entity.User;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface UserService {
    public List<User> getUser() ;

    public User postUser(@RequestBody User user);
}
