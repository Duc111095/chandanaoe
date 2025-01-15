package com.ducnh.chandanaoe.modules.users.controllers;

import com.ducnh.chandanaoe.baseDTO.SuccessResource;
import com.ducnh.chandanaoe.modules.users.entities.User;
import com.ducnh.chandanaoe.modules.users.repositories.UserRepository;
import com.ducnh.chandanaoe.modules.users.resources.UserResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/me")
    public ResponseEntity<?> me() {
        String email = "huynhduc111095@gmail.com";

        User user = userRepository.findByEmail(email).orElseThrow(
                () -> {throw new RuntimeException("User does not exist");}
        );

        UserResource userResource = new UserResource(user.getId(), user.getEmail(), user.getName());
        SuccessResource<UserResource> response = new SuccessResource<>("SUCCESS", userResource);
        return ResponseEntity.ok(response);
    }
}
