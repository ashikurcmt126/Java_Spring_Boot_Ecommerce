package com.ashikur.spring.shoppingcartweb.controllers;

import com.ashikur.spring.shoppingcartweb.config.JwtProvider;
import com.ashikur.spring.shoppingcartweb.dtos.request.LoginDto;
import com.ashikur.spring.shoppingcartweb.dtos.request.RegisterDto;
import com.ashikur.spring.shoppingcartweb.dtos.response.auth.JwtResponse;
import com.ashikur.spring.shoppingcartweb.dtos.response.base.AppResponse;
import com.ashikur.spring.shoppingcartweb.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class AuthController {

    @Autowired
    UsersController usersController;

    @Autowired
    JwtProvider jwtProvider;

    @Autowired
    AuthenticationManager authenticationManager;

    @PostMapping({"auth/register"})
    public ResponseEntity<AppResponse> register(@Valid @RequestBody RegisterDto dto, BindingResult bindingResult) {
        return usersController.registerUser(dto, bindingResult);
    }

    @PostMapping({"auth/login", "users/login"})
    public ResponseEntity<AppResponse> login(@Valid @RequestBody LoginDto loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtProvider.generateJwtToken(authentication);
        User userPrinciple = (User) authentication.getPrincipal();

        User user = ((User) authentication.getPrincipal());
        return ResponseEntity.ok(JwtResponse.build(jwt, user));
    }
}