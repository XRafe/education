package org.education.dto.stage.result;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class CreateStageResultDto {

    private final String answer;
    private final String isDone;
    private final Integer userScore;
    private final Integer stageId;

    public CreateStageResultDto(@JsonProperty("answer") String answer,
                                @JsonProperty("isDone") String isDone,
                                @JsonProperty("userScore") Integer userScore,
                                @JsonProperty("stageId") Integer stageId) {
        this.answer = answer;
        this.isDone = isDone;
        this.userScore = userScore;
        this.stageId = stageId;
    }
}
