package com.example.security4.dto;

import com.example.security4.entity.User;
import lombok.Data;

@Data
public class UserForm {
    private String username;
    private String password;
    private String email;

    public User toEntity() {
        return new User(username,password,email);
    }

    public void toUserForm(User user) {
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.email = user.getEmail();
    }
}
