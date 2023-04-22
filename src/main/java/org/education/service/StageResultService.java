package org.education.service;

import org.education.dto.stage.result.CreateStageResultDto;

public interface StageResultService {
    Integer createOrUpdateStageResult(CreateStageResultDto createStageResult);
}
