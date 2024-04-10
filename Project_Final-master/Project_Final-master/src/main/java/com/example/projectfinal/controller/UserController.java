package com.example.projectfinal.controller;

import com.example.projectfinal.request.user.SignupRequest;
import com.example.projectfinal.response.WrapReponse;
import com.example.projectfinal.response.user.UserResponse;

import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/user")
@Log4j2
public class UserController {
@PostMapping("/signup")
    public WrapReponse<UserResponse> signup(@RequestBody @Valid SignupRequest request ){
    log.info("signup request :{}",request);
    UserResponse res =UserResponse.builder()
            .id("id")
            .email(request.getEmail())
            .username(request.getUsername())
            .build();
return WrapReponse.ok(res);
}
}
