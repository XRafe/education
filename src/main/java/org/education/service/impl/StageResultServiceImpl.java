package org.education.service.impl;

import lombok.RequiredArgsConstructor;
import org.education.dto.stage.result.CreateStageResultDto;
import org.education.repository.StageRepository;
import org.education.repository.StageResultRepository;
import org.education.service.StageResultService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StageResultServiceImpl implements StageResultService {

    private final StageResultRepository stageResultRepository;
    private final StageRepository stageRepository;

    @Override
    public Integer createOrUpdateStageResult(CreateStageResultDto createStageResult) {

        return null;
    }
}
