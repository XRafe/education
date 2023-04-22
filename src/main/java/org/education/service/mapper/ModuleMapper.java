package org.education.service.mapper;

import org.education.dto.module.ModuleDto;
import org.education.entity.Module;
import org.springframework.stereotype.Component;

@Component
public class ModuleMapper {

    public ModuleDto mapModuleToModuleDto(Module module) {
        return new ModuleDto(
                module.getTitle(),
                module.getInfo(),
                module.getScore()
        );
    }
}
