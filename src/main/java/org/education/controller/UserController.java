package org.education.controller;

import lombok.RequiredArgsConstructor;
import org.education.dto.user.RegistrationUserDto;
import org.education.dto.user.UserDto;
import org.education.entity.User;
import org.education.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    @PostMapping("/registration")
    public ResponseEntity<UserDto> registrationUser(RegistrationUserDto registrationUserDto) {
        return new ResponseEntity<>(userService.registrationUser(registrationUserDto), HttpStatus.OK);
    }
}
