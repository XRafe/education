package org.education.service.mapper;

import org.education.dto.stage.StageDto;
import org.education.dto.stage.StageWithResultDto;
import org.education.dto.stage.result.StageResultDto;
import org.education.entity.Stage;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

@Component
public class StageMapper {

    public StageDto mapStageToStageDto(Stage stage) {
        return new StageDto(
                stage.getId(),
                stage.getTitle(),
                stage.getInfo(),
                stage.getData(),
                stage.getType(),
                stage.getScore()
        );
    }

    public List<StageDto> mapStageToStageDto(Collection<Stage> list) {
        return list.stream().map(this::mapStageToStageDto).toList();
    }

    public List<StageWithResultDto> mapStageToStageWithResultDto(Collection<Stage> list) {
        return list.stream().map(m ->
                new StageWithResultDto(
                        m.getId(),
                        m.getTitle(),
                        m.getInfo(),
                        m.getData(),
                        m.getType(),
                        m.getScore(),
                        m.getStageResults()
                                .stream()
                                .map(r -> new StageResultDto(
                                        r.getScore(),
                                        r.getIsDone(),
                                        r.getAnswer()
                                )).toList()
                )
        ).toList();
    }
}
