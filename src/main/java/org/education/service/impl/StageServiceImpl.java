package org.education.service.impl;

import lombok.RequiredArgsConstructor;
import org.education.dto.stage.CreateStageDto;
import org.education.dto.stage.EditStageDto;
import org.education.dto.stage.StageDto;
import org.education.entity.Stage;
import org.education.repository.StageRepository;
import org.education.service.StageService;
import org.education.service.mapper.StageMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class StageServiceImpl implements StageService {

    private final StageRepository stageRepository;
    private final StageMapper stageMapper;


    @Transactional
    @Override
    public Integer createStage(Integer moduleId, CreateStageDto createStage) {
        Stage stage = new Stage(
                createStage.getTitle(),
                createStage.getInfo(),
                createStage.getData(),
                createStage.getType(),
                createStage.getScore(),
                moduleId
        );
        stage = stageRepository.saveAndFlush(stage);

        return stage.getId();
    }


    @Transactional
    @Override
    public StageDto editStage(Integer id, EditStageDto editStage) {
        Stage stage = stageRepository.findById(id).orElseThrow();

        stage.setTitle(editStage.getTitle());
        stage.setInfo(editStage.getInfo());
        stage.setData(editStage.getData());
        stage.setScore(editStage.getScore());

        stageRepository.saveAndFlush(stage);

        return stageMapper.mapStageToStageDto(stage);
    }


    @Transactional
    @Override
    public void deleteStage(Integer id) {
        stageRepository.deleteById(id);
    }
}
