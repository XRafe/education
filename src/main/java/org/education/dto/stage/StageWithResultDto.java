package org.education.dto.stage;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.education.dto.stage.result.StageResultDto;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class StageWithResultDto {

    private final Integer id;
    private final String title;

    private final String info;

    private final String data;

    private final String type;

    private final Integer score;

    private final List<StageResultDto> stageResultDtos;
}
