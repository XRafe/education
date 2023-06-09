package org.education.service.impl;

import lombok.RequiredArgsConstructor;
import org.education.dto.module.*;
import org.education.entity.Module;
import org.education.entity.User;
import org.education.repository.ModuleRepository;
import org.education.repository.UserRepository;
import org.education.repository.criteria.ModuleCriteriaRepository;
import org.education.service.ModuleService;
import org.education.service.mapper.ModuleMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ModuleServiceImpl implements ModuleService {

    private final ModuleRepository moduleRepository;
    private final ModuleMapper moduleMapper;
    private final UserRepository userRepository;
    private final ModuleCriteriaRepository moduleCriteriaRepository;


    @Transactional
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


    @Transactional
    @Override
    public ModuleDto editModule(Integer id, EditModuleDto editModule) {
        Module module = moduleRepository.findById(id).orElseThrow();

        module.setTitle(editModule.getTitle());
        module.setInfo(editModule.getInfo());

        moduleRepository.saveAndFlush(module);

        return moduleMapper.mapModuleToModuleDto(module);
    }

    @Override
    public ModuleDto getModuleById(Integer id) {
        Module module = moduleRepository.findById(id).orElseThrow();
        return moduleMapper.mapModuleToModuleDto(module);
    }

    @Override
    public void deleteModule(Integer id) {
        moduleRepository.deleteById(id);
    }

    @Override
    public List<ModuleWithStageDto> getAllByCourceId(Integer courceId) {
        List<Module> list = moduleRepository.findAllByCourceId(courceId);
        return moduleMapper.mapModuleToModuleWithStageDto(list);
    }

    @Override
    public List<ModuleWithStageResultDto> getAllByCourceIdAndUserId(Integer courceId, String email) {
        User user = userRepository.findByEmail(email).orElseThrow();
        List<Module> list = moduleCriteriaRepository.getAllByCourceWithStageResultIdAndUserId(courceId, user.getId());

        return moduleMapper.mapModuleToModuleWithStageResultDto(list);
    }
}
