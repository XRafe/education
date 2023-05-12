package org.education.service;

import org.education.dto.module.*;

import java.util.List;

public interface ModuleService {

    Integer createModule(Integer courceId, CreateModuleDto createModule);

    ModuleDto editModule(Integer id, EditModuleDto editModule);

    ModuleDto getModuleById(Integer id);

    void deleteModule(Integer id);

    List<ModuleWithStageDto> getAllByCourceId(Integer courceId);

    List<ModuleWithStageResultDto> getAllByCourceIdAndUserId(Integer courceId, String email);
}
