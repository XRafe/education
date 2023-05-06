package org.education.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.education.cookie.ActionWithCookie;
import org.education.dto.module.CreateModuleDto;
import org.education.dto.module.EditModuleDto;
import org.education.dto.module.ModuleDto;
import org.education.dto.module.ModuleWithStageDto;
import org.education.jwt.ActionWithJwt;
import org.education.service.ModuleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ModuleController {

    private final ActionWithJwt actionWithJwt;
    private final ActionWithCookie actionWithCookie;
    private final ModuleService moduleService;

    @PostMapping("cource/{courceId}/module/create")
    public Integer createModule(@PathVariable("courceId") Integer courceId, CreateModuleDto createModuleDto) {
        return moduleService.createModule(courceId, createModuleDto);
    }

    @PutMapping("cource/module/{id}/edit")
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

    @GetMapping("cource/{courceId}/module/list")
    public List<ModuleWithStageDto> getAllByCourceId(@PathVariable("courceId") Integer courceId) {
        return moduleService.getAllByCourceId(courceId);
    }

    @GetMapping("cource/{courceId}/module/list/subscribe")
    public List<ModuleWithStageDto> getAllByCourceIdAndUserId(HttpServletRequest httpServletRequest, @PathVariable("courceId") Integer courceId) {
        String token = actionWithCookie.getTokenFromRequest(httpServletRequest);
        String email = actionWithJwt.getEmailByToken(token);
        return moduleService.getAllByCourceIdAndUserId(courceId, email);
    }
}
