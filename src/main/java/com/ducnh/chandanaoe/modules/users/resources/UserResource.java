package com.ducnh.chandanaoe.modules.users.resources;

public class UserResource {
    private final Long id;
    private final String email;
    private final String name;

    public UserResource(Long id, String email, String name) {
        this.email = email;
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return this.id;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }
}
