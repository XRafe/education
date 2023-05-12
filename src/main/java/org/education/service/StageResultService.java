package org.education.service;

import org.education.dto.stage.result.CreateStageResultDto;

public interface StageResultService {
    void createOrUpdateStageResult(String email, CreateStageResultDto createStageResult);


}
