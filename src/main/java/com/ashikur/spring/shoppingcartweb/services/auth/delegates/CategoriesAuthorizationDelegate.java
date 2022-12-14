package com.ashikur.spring.shoppingcartweb.services.auth.delegates;

import com.ashikur.spring.shoppingcartweb.models.Category;
import com.ashikur.spring.shoppingcartweb.models.User;
import com.ashikur.spring.shoppingcartweb.services.auth.AuthorizationService;

public class CategoriesAuthorizationDelegate {
    private final AuthorizationService authorizationService;

    public CategoriesAuthorizationDelegate(AuthorizationService authorizationService) {
        this.authorizationService = authorizationService;
    }

    public boolean canCreateCategories(User user) {
        return this.authorizationService.isUserAdmin(user);
    }

    public boolean canUpdateCategories(User user, Category category) {
        return this.authorizationService.isUserAdmin(user);
    }

    public boolean canDeleteCategories(User user) {
        return this.authorizationService.isUserAdmin(user);
    }

    public boolean canReadCategories(User user) {
        return true;
    }
}
