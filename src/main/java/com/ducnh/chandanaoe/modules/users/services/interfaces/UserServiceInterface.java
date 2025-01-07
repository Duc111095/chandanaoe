package com.ducnh.chandanaoe.modules.users.services.interfaces;

import com.ducnh.chandanaoe.modules.users.dtos.LoginRequest;
import com.ducnh.chandanaoe.modules.users.dtos.LoginResponse;

public interface UserServiceInterface {
    LoginResponse login(LoginRequest request);
}
