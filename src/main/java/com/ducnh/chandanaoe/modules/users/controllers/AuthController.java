package com.ducnh.chandanaoe.modules.users.controllers;

import com.ducnh.chandanaoe.baseDTO.ErrorResource;
import com.ducnh.chandanaoe.modules.users.resources.LoginRequest;
import com.ducnh.chandanaoe.modules.users.resources.LoginResource;
import com.ducnh.chandanaoe.modules.users.services.impl.UserService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Validated
@RestController
@RequestMapping("api/v1/auth")
public class AuthController {

    private final UserService userService;
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/authenticate")
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequest request) {
        Object result = userService.authenticate(request);

        if (result instanceof LoginResource loginResource) {
            return ResponseEntity.ok(loginResource);
        }

        if (result instanceof ErrorResource errorResource) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResource);
        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Network Error");
    }
}
