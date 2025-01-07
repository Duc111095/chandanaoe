package com.ducnh.chandanaoe.modules.users.controllers;

import com.ducnh.chandanaoe.modules.users.dtos.LoginRequest;
import com.ducnh.chandanaoe.modules.users.dtos.LoginResponse;
import com.ducnh.chandanaoe.modules.users.services.impl.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/auth")
public class AuthController {

    private final UserService userService;
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        LoginResponse auth = userService.login(request);
        return ResponseEntity.ok(auth);
    }
}
