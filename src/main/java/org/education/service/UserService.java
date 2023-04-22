package org.education.service;

import org.education.dto.user.RegistrationUserDto;
import org.education.dto.user.UserDto;

public interface UserService {

    UserDto registrationUser(RegistrationUserDto registrationUserDto);
}
