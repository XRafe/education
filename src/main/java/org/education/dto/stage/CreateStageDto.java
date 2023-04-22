package org.education.dto.stage;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class CreateStageDto {

    private final String title;

    private final String info;

    private final String data;

    private final String type;

    private final String score;

    public CreateStageDto(@JsonProperty("title") String title,
                          @JsonProperty("info") String info,
                          @JsonProperty("data") String data,
                          @JsonProperty("type") String type,
                          @JsonProperty("score") String score) {
        this.title = title;
        this.info = info;
        this.data = data;
        this.type = type;
        this.score = score;
    }
}
