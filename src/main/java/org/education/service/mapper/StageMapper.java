package org.education.service.mapper;

import org.education.dto.stage.StageDto;
import org.education.entity.Stage;
import org.springframework.stereotype.Component;

@Component
public class StageMapper {

    public StageDto mapStageToStageDto(Stage stage) {
        return new StageDto(
                stage.getTitle(),
                stage.getInfo(),
                stage.getData(),
                stage.getType(),
                stage.getScore()
        );
    }
}
