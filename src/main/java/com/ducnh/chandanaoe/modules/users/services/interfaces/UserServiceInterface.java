package com.ducnh.chandanaoe.modules.users.services.interfaces;

import com.ducnh.chandanaoe.modules.users.resources.LoginRequest;

public interface UserServiceInterface {
    Object authenticate(LoginRequest request);
}
