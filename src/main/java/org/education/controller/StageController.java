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
@RequestMapping("/stage")
@RequiredArgsConstructor
public class StageController {

    private final StageService stageService;
    @PostMapping("/create")
    public Integer createStage(CreateStageDto createStageDto) {
        return stageService.createStage(createStageDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StageDto> editStage(@PathVariable("id") Integer id,
                                             EditStageDto editStageDto) {
        return new ResponseEntity<>(stageService.editStage(id, editStageDto), HttpStatus.OK);
    }


}
