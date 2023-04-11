package org.education.controller;

import org.education.dto.stage.result.CreateStageResultDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stage/result")
public class StageResultController {

    @PostMapping
    public Integer createOrUpdateStageResult(CreateStageResultDto createStageResult) {
        return null;
    }
}
