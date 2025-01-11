package com.ducnh.chandanaoe.modules.users.resources;

public class UserResource {
    private final Long id;
    private final String email;

    public UserResource(Long id, String email) {
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
