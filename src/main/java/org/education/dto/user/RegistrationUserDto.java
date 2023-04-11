package org.education.dto.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class RegistrationUserDto {
    private final String name;

    private final String secondName;

    private final String email;

    private final String password;

    public RegistrationUserDto(@JsonProperty("name") String name,
                               @JsonProperty("secondName") String secondName,
                               @JsonProperty("email") String email,
                               @JsonProperty("password") String password) {
        this.name = name;
        this.secondName = secondName;
        this.email = email;
        this.password = password;
    }
}
