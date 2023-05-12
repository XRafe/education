package org.education.service.impl;

import lombok.RequiredArgsConstructor;
import org.education.dto.user.AuthenticatedUserDto;
import org.education.dto.user.EditUserDto;
import org.education.dto.user.RegistrationUserDto;
import org.education.dto.user.UserDto;
import org.education.entity.User;
import org.education.jwt.ActionWithJwt;
import org.education.repository.UserRepository;
import org.education.service.UserService;
import org.education.service.mapper.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final ActionWithJwt actionWithJwt;


    @Transactional
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


    @Transactional
    @Override
    public String authenticatedUser(AuthenticatedUserDto authenticatedUserDto) {
        User user = userRepository.findByEmail(authenticatedUserDto.getEmail())
                .orElseThrow();
        if (user.getPassword().equals(authenticatedUserDto.getPassword())) {
            return actionWithJwt.createJwtForUser(authenticatedUserDto);
        }

        return null;
    }

    @Override
    public void editUser(String email, EditUserDto editUserDto) {
        User user = userRepository.findByEmail(email)
                .orElseThrow();

        user.setEmail(editUserDto.getEmail());
        user.setName(editUserDto.getName());
        user.setSecondName(editUserDto.getSecondName());
        user.setPassword(editUserDto.getPassword());
        user.setInfo(editUserDto.getInfo());

        userRepository.saveAndFlush(user);
    }

}
