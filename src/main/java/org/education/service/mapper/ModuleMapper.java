package org.education.service.mapper;

import lombok.RequiredArgsConstructor;
import org.education.dto.module.ModuleDto;
import org.education.dto.module.ModuleWithStageDto;
import org.education.entity.Module;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ModuleMapper {

    private final StageMapper stageMapper;

    public ModuleDto mapModuleToModuleDto(Module module) {
        return new ModuleDto(
                module.getId(),
                module.getTitle(),
                module.getInfo(),
                module.getScore()
        );
    }

    public List<ModuleWithStageDto> mapModuleToModuleWithStageDto(Collection<Module> modules) {
        return modules.stream().map(m -> new ModuleWithStageDto(
                m.getId(),
                m.getTitle(),
                m.getInfo(),
                m.getScore(),
                m.getCourceId(),
                stageMapper.mapStageToStageDto(m.getStages())
        )).toList();
    }
}
