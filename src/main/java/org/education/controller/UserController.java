package org.education.controller;

import org.education.dto.user.RegistrationUserDto;
import org.education.entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @PostMapping("/registration")
    public ResponseEntity<User> registrationUser(RegistrationUserDto registrationUser) {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
