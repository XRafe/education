package org.education.controller;

import lombok.RequiredArgsConstructor;
import org.education.dto.stage.result.CreateStageResultDto;
import org.education.service.StageResultService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stage/result")
@RequiredArgsConstructor
public class StageResultController {

    private final StageResultService stageResultService;

    @PostMapping
    public Integer createOrUpdateStageResult(CreateStageResultDto createStageResultDto) {
        return stageResultService.createOrUpdateStageResult(createStageResultDto);
    }
}
