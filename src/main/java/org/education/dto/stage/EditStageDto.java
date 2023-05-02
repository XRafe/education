package org.education.dto.stage;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class EditStageDto {
    private final String title;

    private final String info;

    private final String data;

    private final Integer score;

    public EditStageDto(@JsonProperty("title") String title,
                        @JsonProperty("info") String info,
                        @JsonProperty("data") String data,
                        @JsonProperty("score") Integer score) {
        this.title = title;
        this.info = info;
        this.data = data;
        this.score = score;
    }
}
