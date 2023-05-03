package org.education.dto.module;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class CreateModuleDto {
    private final String title;

    private final String info;

    private final Integer score;

    public CreateModuleDto(@JsonProperty("title") String title,
                           @JsonProperty("info") String info,
                           @JsonProperty("score") Integer score) {
        this.title = title;
        this.info = info;
        this.score = score;
    }
}
