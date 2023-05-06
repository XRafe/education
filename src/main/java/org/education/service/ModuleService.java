package org.education.service;

import org.education.dto.module.CreateModuleDto;
import org.education.dto.module.EditModuleDto;
import org.education.dto.module.ModuleDto;
import org.education.dto.module.ModuleWithStageDto;

import java.util.List;

public interface ModuleService {

    Integer createModule(Integer courceId, CreateModuleDto createModule);

    ModuleDto editModule(Integer id, EditModuleDto editModule);

    ModuleDto getModuleById(Integer id);

    void deleteModule(Integer id);

    List<ModuleWithStageDto> getAllByCourceId(Integer courceId);

    List<ModuleWithStageDto> getAllByCourceIdAndUserId(Integer courceId, String email);
}
