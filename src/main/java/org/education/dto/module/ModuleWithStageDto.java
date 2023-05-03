package org.education.dto.module;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.education.dto.stage.StageDto;
import org.education.entity.Stage;

import java.util.List;
import java.util.Set;

@Getter
@RequiredArgsConstructor
public class ModuleWithStageDto {
    private final Integer id;
    private final String title;
    private final String info;
    private final Integer score;
    private final Integer courceId;
    private final List<StageDto> stages;
}
