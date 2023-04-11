package org.education.controller;

import org.education.dto.stage.CreateStageDto;
import org.education.dto.stage.EditStageDto;
import org.education.dto.stage.StageDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stage")
public class StageController {

    @PostMapping("/create")
    public Integer createStage(CreateStageDto createStage) {
        return null;
    }

    @PutMapping("/{id}")
    public ResponseEntity<StageDto> getStage(@PathVariable("id") Integer id,
                                             EditStageDto editStage) {
        return null;
    }


}
