package org.education.dto.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class AuthenticatedUserDto {

    private final String email;
    private final String password;

    public AuthenticatedUserDto(@JsonProperty("email") String email,
                                @JsonProperty("password") String password) {
        this.email = email;
        this.password = password;
    }
}
