package com.ducnh.chandanaoe.modules.users.services.impl;

import com.ducnh.chandanaoe.modules.users.resources.LoginRequest;
import com.ducnh.chandanaoe.modules.users.resources.LoginResource;
import com.ducnh.chandanaoe.modules.users.resources.UserResource;
import com.ducnh.chandanaoe.services.BaseService;
import com.ducnh.chandanaoe.modules.users.services.interfaces.UserServiceInterface;
import org.springframework.stereotype.Service;

@Service
public class UserService extends BaseService implements UserServiceInterface {

    @Override
    public LoginResource login(LoginRequest request) {
        try {
            String email = request.getEmail();
            String password = request.getPassword();
            String token = "random_token";
            UserResource user = new UserResource(1L, "ducnh111095@gmail.com");
            return new LoginResource(token, user);
        } catch (Exception e) {
            throw new RuntimeException("Co van de xay ra");
        }
    }
}
