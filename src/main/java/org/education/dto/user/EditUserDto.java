package org.education.dto.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class EditUserDto {

    private final String name;
    private final String secondName;
    private final String email;
    private final String password;
    private final String info;

    public EditUserDto(@JsonProperty("name") String name,
                       @JsonProperty("secondName") String secondName,
                       @JsonProperty("email") String email,
                       @JsonProperty("password") String password,
                       @JsonProperty("info") String info) {
        this.name = name;
        this.secondName = secondName;
        this.email = email;
        this.password = password;
        this.info = info;
    }
}
