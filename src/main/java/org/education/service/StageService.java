package org.education.service;

import org.education.dto.stage.CreateStageDto;
import org.education.dto.stage.EditStageDto;
import org.education.dto.stage.StageDto;

public interface StageService {
    Integer createStage(Integer moduleId, CreateStageDto createStage);

    StageDto editStage(Integer id, EditStageDto editStage);

}
