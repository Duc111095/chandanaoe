package com.ducnh.chandanaoe.modules.users.resources;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class LoginRequest {

    @NotBlank(message = "Not Blank Email")
    @Email(message = "Invalid Email")
    private String email;

    @NotBlank(message = "Password cannot blank")
    @Size(min = 6, message = "Invalid password")
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
