package org.education.dto.module;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class CreateModuleDto {
    private final String title;

    private final String info;

    private final Integer score;

    private final Integer courceId;

    public CreateModuleDto(@JsonProperty("title") String title,
                           @JsonProperty("info") String info,
                           @JsonProperty("score") Integer score,
                           @JsonProperty("courceId") Integer courceId) {
        this.title = title;
        this.info = info;
        this.score = score;
        this.courceId = courceId;
    }
}
