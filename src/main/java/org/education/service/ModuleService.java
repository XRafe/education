package org.education.service;

import org.education.dto.module.CreateModuleDto;
import org.education.dto.module.EditModuleDto;
import org.education.dto.module.ModuleDto;

public interface ModuleService {

    Integer createModule(Integer courceId, CreateModuleDto createModule);

    ModuleDto editModule(Integer id, EditModuleDto editModule);

    ModuleDto getModuleById(Integer id);

    void deleteModule(Integer id);
}
