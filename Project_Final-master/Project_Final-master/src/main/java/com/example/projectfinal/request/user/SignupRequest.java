package com.example.projectfinal.request.user;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SignupRequest {
    @NotBlank(message = "user is require")
    @Pattern(regexp = "^[a-zA-Z0-9-_]{6,50}",message = "user wrong format")
    private String username;
    private String password;
    @NotBlank(message = "email is require")
    private String email;


}
