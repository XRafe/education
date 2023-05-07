package org.education.controller;

import lombok.RequiredArgsConstructor;
import org.education.dto.stage.CreateStageDto;
import org.education.dto.stage.EditStageDto;
import org.education.dto.stage.StageDto;
import org.education.service.StageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class StageController {

    private final StageService stageService;

    @PostMapping("module/{moduleId}/stage/create")
    public Integer createStage(@PathVariable("moduleId") Integer moduleId,
                               @RequestBody CreateStageDto createStageDto) {
        return stageService.createStage(moduleId, createStageDto);
    }

    @PutMapping("module/stage/{id}/edit")
    public ResponseEntity<StageDto> editStage(@PathVariable("id") Integer id,
                                              @RequestBody EditStageDto editStageDto) {
        return new ResponseEntity<>(stageService.editStage(id, editStageDto), HttpStatus.OK);
    }

    @DeleteMapping("module/stage/{id}/delete")
    public void deleteStage(@PathVariable("id") Integer id) {
        stageService.deleteStage(id);
    }
}
