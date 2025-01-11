package com.ducnh.chandanaoe.modules.users.services.interfaces;

import com.ducnh.chandanaoe.modules.users.resources.LoginRequest;
import com.ducnh.chandanaoe.modules.users.resources.LoginResource;

public interface UserServiceInterface {
    LoginResource login(LoginRequest request);
}
