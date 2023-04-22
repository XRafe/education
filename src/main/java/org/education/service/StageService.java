package org.education.service;

import org.education.dto.stage.CreateStageDto;
import org.education.dto.stage.EditStageDto;
import org.education.dto.stage.StageDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

public interface StageService {
    Integer createStage(CreateStageDto createStage);

    StageDto editStage(Integer id, EditStageDto editStage);

}
