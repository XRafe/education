package org.education.service.mapper;

import org.education.dto.user.UserDto;
import org.education.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserDto mapUserToUserDto(User user) {
        return new UserDto(
                user.getName(),
                user.getSecondName());
    }
}
