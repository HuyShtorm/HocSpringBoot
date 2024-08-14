package com.example.projectfinal.controller;

import com.example.projectfinal.enumStatic.UserStatus;
import com.example.projectfinal.request.SearchRequest;
import com.example.projectfinal.request.user.ActiveRequest;
import com.example.projectfinal.request.user.SignupRequest;
import com.example.projectfinal.response.WrapResponse;
import com.example.projectfinal.response.user.UserResponse;

import com.example.projectfinal.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/user")
@Log4j2
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public WrapResponse<UserResponse> signup(@RequestBody @Valid SignupRequest request) {
        log.info("signup request :{}", request);

        return WrapResponse.ok(userService.createUser(request));
    }
@PostMapping("/profile/{userId}")
public  WrapResponse<UserResponse> getProfile(@PathVariable String userId){
    return WrapResponse.ok(userService.getProfile(userId));
}


//    @GetMapping("/{id}"){
//        public WrapResponse<UserResponse> getUser(@PathVariable String id){
//            log.info("Get user by id : {}",id);
//            return WrapResponse.ok(userService.getUser());
//        }
//    }

    @PostMapping("/active")
    public WrapResponse<UserResponse> active(@RequestBody @Valid ActiveRequest request) {
        return WrapResponse.ok(userService.active(request));
    }
    @PutMapping("/update-status/{id}")
    public WrapResponse<UserResponse> updateStatus(@PathVariable String id){
        log.info("Update status user by id :{}",id);
        return WrapResponse.ok(userService.updateUserStatus(id, UserStatus.ACTIVE));
    }

    @GetMapping("/all")
        public WrapResponse<List<UserResponse>> getAllUser(){
            log.info("Get all user");
            return WrapResponse.ok(userService.getAllUser());
        }


}
