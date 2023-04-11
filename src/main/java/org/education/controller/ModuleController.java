package org.education.controller;

import org.education.dto.module.CreateModuleDto;
import org.education.dto.module.EditModuleDto;
import org.education.dto.module.ModuleDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/module")
public class ModuleController {

    @PostMapping("/create")
    public Integer createModule(CreateModuleDto createModule) {
        return 1;
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<ModuleDto> editModule(@PathVariable("id") Integer id,
                                                EditModuleDto editModule) {
        return null;
    }

    @GetMapping("/{id}")
    public ModuleDto getModuleById(@PathVariable("id") Integer id) {
        return null;
    }
}
