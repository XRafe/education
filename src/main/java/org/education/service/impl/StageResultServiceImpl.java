package org.education.service.impl;

import lombok.RequiredArgsConstructor;
import org.education.dto.stage.result.CreateStageResultDto;
import org.education.entity.StageResult;
import org.education.entity.User;
import org.education.repository.StageResultRepository;
import org.education.repository.UserRepository;
import org.education.service.StageResultService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class StageResultServiceImpl implements StageResultService {

    private final StageResultRepository stageResultRepository;
    private final UserRepository userRepository;

    @Transactional
    @Override
    public void createOrUpdateStageResult(String email, CreateStageResultDto createStageResult) {
        StageResult stageResult;
        User user = userRepository.findByEmail(email).orElseThrow();

        if (stageResultRepository
                .existsByUserIdAndStageId(user.getId(),
                        createStageResult.getStageId())) {
            stageResult = stageResultRepository.findByUserIdAndStageId(user.getId(),
                    createStageResult.getStageId());
            stageResult.setAnswer(createStageResult.getAnswer());
            stageResult.setIsDone(createStageResult.getIsDone());
            stageResult.setScore(createStageResult.getUserScore());
        } else {
            stageResult = new StageResult(
                    createStageResult.getUserScore(),
                    createStageResult.getIsDone(),
                    createStageResult.getAnswer(),
                    user.getId(),
                    createStageResult.getStageId()
            );
        }

        stageResultRepository.saveAndFlush(stageResult);

    }
}
