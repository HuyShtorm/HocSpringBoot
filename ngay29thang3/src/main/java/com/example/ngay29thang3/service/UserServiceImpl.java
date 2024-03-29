package com.example.ngay29thang3.service;

import com.example.ngay29thang3.Entity.User;
import org.springframework.stereotype.Component;
import org.springframework.http.ResponseEntity;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.RequestBody;
@Component
public class UserServiceImpl implements UserService {
    private List<User> users = new ArrayList<>();

    @Override
    public List<User> getUser() {
        return users;
    }

    @Override
    public User postUser(User user) {
        users.add(user);
        return user;
    }
}
