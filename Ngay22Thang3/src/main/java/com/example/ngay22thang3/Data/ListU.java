package com.example.ngay22thang3.Data;

import com.example.ngay22thang3.Entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration; // Import Configuration annotation

import java.util.ArrayList;
import java.util.List;

@Configuration
public class ListU {
    @Bean
    public List<User> userList() {
        List<User> users = new ArrayList<>();


        users.add(new User("1", "user1"));
        users.add(new User("2", "user2"));
        users.add(new User("3", "user3"));
        users.add(new User("4", "user4"));
        users.add(new User("5", "user5"));
        users.add(new User("6", "user6"));
        users.add(new User("7", "user7"));
        users.add(new User("8", "user8"));
        users.add(new User("9", "user9"));
        users.add(new User("10", "user10"));

        return users;
    }
}
