package com.ducnh.chandanaoe.modules.users.dtos;

public class UserDTO {
    private final Long id;
    private final String email;

    public UserDTO(Long id, String email) {
        this.email = email;
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

    public String getEmail() {
        return email;
    }
}
