package org.education.dto.module;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.education.dto.stage.StageWithResultDto;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class ModuleWithStageResultDto {
    private final Integer id;
    private final String title;
    private final String info;
    private final Integer score;
    private final Integer courceId;
    private final List<StageWithResultDto> stages;
}
