package com.ducnh.chandanaoe.modules.users.services.impl;

import com.ducnh.chandanaoe.baseDTO.ErrorResource;
import com.ducnh.chandanaoe.modules.users.entities.User;
import com.ducnh.chandanaoe.modules.users.repositories.UserRepository;
import com.ducnh.chandanaoe.modules.users.resources.LoginRequest;
import com.ducnh.chandanaoe.modules.users.resources.LoginResource;
import com.ducnh.chandanaoe.modules.users.resources.UserResource;
import com.ducnh.chandanaoe.services.BaseService;
import com.ducnh.chandanaoe.modules.users.services.interfaces.UserServiceInterface;
import com.ducnh.chandanaoe.services.JwtService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService extends BaseService implements UserServiceInterface {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private JwtService jwtService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Object authenticate(LoginRequest request) {
        try {
            String email = request.getEmail();
            String password = request.getPassword();

            User user = userRepository.findByEmail(email).orElseThrow(
                    () -> new BadCredentialsException("Email hoac mat khau khong chinh xac")
            );

            if (!passwordEncoder.matches(password, user.getPassword())) {
                throw new BadCredentialsException("Email hoac mat khau khong chinh xac");
            }

            UserResource userResource = new UserResource(user.getId(), user.getEmail(), user.getName());

            String token = jwtService.generateToken(user.getId(), user.getEmail());

            return new LoginResource(token, userResource);
        } catch (BadCredentialsException e) {
            logger.error("Loi xac thuc {}", e.getMessage());
            Map<String, String> errors = new HashMap<>();
            errors.put("message", e.getMessage());
            return new ErrorResource("Co van de xay ra trong qua trinh xac thuc", errors);
        }
    }
}
