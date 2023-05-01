package org.education.service.impl;

import lombok.RequiredArgsConstructor;
import org.education.dto.user.AuthenticatedUserDto;
import org.education.dto.user.RegistrationUserDto;
import org.education.dto.user.UserDto;
import org.education.entity.User;
import org.education.jwt.ActionWithJwt;
import org.education.repository.UserRepository;
import org.education.service.UserService;
import org.education.service.mapper.UserMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final ActionWithJwt actionWithJwt;

    @Override
    public UserDto registrationUser(RegistrationUserDto registrationUserDto) {
        User user = new User(
                registrationUserDto.getName(),
                registrationUserDto.getSecondName(),
                registrationUserDto.getEmail(),
                registrationUserDto.getPassword(),
                "",
                "");

        user = userRepository.saveAndFlush(user);

        return userMapper.mapUserToUserDto(user);
    }

    @Override
    public String authenticatedUser(AuthenticatedUserDto authenticatedUserDto) {
        User user = userRepository.findByEmail(authenticatedUserDto.getEmail())
                .orElseThrow();
        if (user.getPassword().equals(authenticatedUserDto.getPassword())) {
            return actionWithJwt.createJwtForUser(authenticatedUserDto);
        }

        return null;
    }

}
