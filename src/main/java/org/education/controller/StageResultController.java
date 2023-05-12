package org.education.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.education.cookie.ActionWithCookie;
import org.education.dto.stage.result.CreateStageResultDto;
import org.education.jwt.ActionWithJwt;
import org.education.service.StageResultService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stage/result")
@RequiredArgsConstructor
public class StageResultController {

    private final StageResultService stageResultService;
    private final ActionWithJwt actionWithJwt;
    private final ActionWithCookie actionWithCookie;

    @PostMapping
    public ResponseEntity createOrUpdateStageResult(HttpServletRequest httpServletRequest,
                                                    @RequestBody CreateStageResultDto createStageResultDto) {
        String token = actionWithCookie.getTokenFromRequest(httpServletRequest);
        String email = actionWithJwt.getEmailByToken(token);

        stageResultService.createOrUpdateStageResult(email, createStageResultDto);
        return new ResponseEntity(HttpStatus.OK);
    }
}
