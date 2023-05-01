package org.education.controller;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.education.cookie.ActionWithCookie;
import org.education.dto.user.AuthenticatedUserDto;
import org.education.dto.user.RegistrationUserDto;
import org.education.dto.user.UserDto;
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
    private final ActionWithCookie actionWithCookie;

    @PostMapping("/registration")
    public ResponseEntity<UserDto> registrationUser(RegistrationUserDto registrationUserDto) {
        return new ResponseEntity<>(userService.registrationUser(registrationUserDto), HttpStatus.OK);
    }

    @PostMapping("/authenticated")
    public ResponseEntity<String> authenticatedUser(HttpServletResponse httpServletResponse,
                                                    AuthenticatedUserDto authenticatedUserDto) {
        actionWithCookie.createCookie(httpServletResponse, userService.authenticatedUser(authenticatedUserDto));
        return new ResponseEntity<>("Добро пожаловать " + authenticatedUserDto.getEmail(),
                HttpStatus.OK);
    }
}
