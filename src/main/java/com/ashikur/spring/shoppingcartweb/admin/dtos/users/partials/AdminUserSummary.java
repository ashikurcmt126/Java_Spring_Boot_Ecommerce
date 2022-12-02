package com.ashikur.spring.shoppingcartweb.admin.dtos.users.partials;

import com.ashikur.spring.shoppingcartweb.models.User;
import com.ashikur.spring.shoppingcartweb.dtos.response.users.partials.UserIdAndUsernameDto;

public class AdminUserSummary extends UserIdAndUsernameDto {
    private final String email;

    public AdminUserSummary(Long id, String username, String email) {
        super(id, username);
        this.email=email;
    }

    public static AdminUserSummary build(User user) {
        return new AdminUserSummary(user.getId(), user.getUsername(), user.getEmail());
    }

    public String getEmail() {
        return email;
    }
}
