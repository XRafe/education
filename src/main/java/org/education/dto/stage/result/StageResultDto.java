package org.education.dto.stage.result;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class StageResultDto {

    private final Integer score;

    private final String isDone;

    private final String answer;
}
