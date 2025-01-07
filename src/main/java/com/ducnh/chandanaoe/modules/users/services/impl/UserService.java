package com.ducnh.chandanaoe.modules.users.services.impl;

import com.ducnh.chandanaoe.modules.users.dtos.LoginRequest;
import com.ducnh.chandanaoe.modules.users.dtos.LoginResponse;
import com.ducnh.chandanaoe.modules.users.dtos.UserDTO;
import com.ducnh.chandanaoe.services.BaseService;
import com.ducnh.chandanaoe.modules.users.services.interfaces.UserServiceInterface;
import org.springframework.stereotype.Service;

@Service
public class UserService extends BaseService implements UserServiceInterface {

    @Override
    public LoginResponse login(LoginRequest request) {
        try {
            String email = request.getEmail();
            String password = request.getPassword();
            String token = "random_token";
            UserDTO user = new UserDTO(1L, "ducnh111095@gmail.com");
            return new LoginResponse(token, user);
        } catch (Exception e) {
            throw new RuntimeException("Co van de xay ra");
        }
    }
}
