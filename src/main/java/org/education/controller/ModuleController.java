package org.education.controller;

import lombok.RequiredArgsConstructor;
import org.education.dto.module.CreateModuleDto;
import org.education.dto.module.EditModuleDto;
import org.education.dto.module.ModuleDto;
import org.education.service.ModuleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ModuleController {

    private final ModuleService moduleService;

    @PostMapping("cource/{idCource}/module/create")
    public Integer createModule(@PathVariable("idCource") Integer courceId, CreateModuleDto createModuleDto) {
        return moduleService.createModule(courceId, createModuleDto);
    }

    @PutMapping("cource/module/edit/{id}")
    public ResponseEntity<ModuleDto> editModule(@PathVariable("id") Integer id,
                                                EditModuleDto editModuleDto) {
        return new ResponseEntity<>(moduleService.editModule(id, editModuleDto), HttpStatus.OK);
    }

    @GetMapping("cource/module/{id}")
    public ModuleDto getModuleById(@PathVariable("id") Integer id) {
        return moduleService.getModuleById(id);
    }

    @DeleteMapping("cource/module/{id}/delete")
    public void deleteModule(@PathVariable("id") Integer id) {
        moduleService.deleteModule(id);
    }
}
