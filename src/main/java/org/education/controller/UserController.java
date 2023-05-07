package org.education.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.education.cookie.ActionWithCookie;
import org.education.dto.user.AuthenticatedUserDto;
import org.education.dto.user.EditUserDto;
import org.education.dto.user.RegistrationUserDto;
import org.education.dto.user.UserDto;
import org.education.jwt.ActionWithJwt;
import org.education.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final ActionWithCookie actionWithCookie;
    private final ActionWithJwt actionWithJwt;

    @PostMapping("/registration")
    public ResponseEntity<UserDto> registrationUser(@RequestBody RegistrationUserDto registrationUserDto) {
        return new ResponseEntity<>(userService.registrationUser(registrationUserDto), HttpStatus.OK);
    }

    @PostMapping("/authenticated")
    public ResponseEntity<String> authenticatedUser(HttpServletResponse httpServletResponse,
                                                    @RequestBody AuthenticatedUserDto authenticatedUserDto) {
        actionWithCookie.createCookie(httpServletResponse, userService.authenticatedUser(authenticatedUserDto));
        return new ResponseEntity<>("Добро пожаловать " + authenticatedUserDto.getEmail(),
                HttpStatus.OK);
    }

    @PutMapping("/edit")
    public ResponseEntity editUser(HttpServletRequest httpServletRequest,
                                   @RequestBody EditUserDto editUserDto) {
        String token = actionWithCookie.getTokenFromRequest(httpServletRequest);
        String email = actionWithJwt.getEmailByToken(token);

        userService.editUser(email, editUserDto);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
