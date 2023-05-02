package org.education.service.impl;

import lombok.RequiredArgsConstructor;
import org.education.dto.module.CreateModuleDto;
import org.education.dto.module.EditModuleDto;
import org.education.dto.module.ModuleDto;
import org.education.entity.Module;
import org.education.repository.ModuleRepository;
import org.education.service.ModuleService;
import org.education.service.mapper.ModuleMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ModuleServiceImpl implements ModuleService {

    private final ModuleRepository moduleRepository;
    private final ModuleMapper moduleMapper;

    @Override
    public Integer createModule(Integer courceId, CreateModuleDto createModule) {
        Module module = new Module(
                createModule.getTitle(),
                createModule.getInfo(),
                createModule.getScore(),
                courceId);

        module = moduleRepository.saveAndFlush(module);

        return module.getId();
    }

    @Override
    public ModuleDto editModule(Integer id, EditModuleDto editModule) {
        Module module = moduleRepository.findById(id).orElseThrow();


        moduleRepository.saveAndFlush(module);

        return moduleMapper.mapModuleToModuleDto(module);
    }

    @Override
    public ModuleDto getModuleById(Integer id) {
        Module module = moduleRepository.findById(id).orElseThrow();
        return moduleMapper.mapModuleToModuleDto(module);
    }
}
