package org.education.controller;

import lombok.RequiredArgsConstructor;
import org.education.dto.cource.CourceDto;
import org.education.dto.cource.CreateCourceDto;
import org.education.dto.cource.EditCourceDto;
import org.education.service.CourceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cource")
@RequiredArgsConstructor
public class CourceController {

    private final CourceService courceService;

    @PostMapping("/create")
    public Integer createCourceWithChat(CreateCourceDto createCourceDto) {
        return courceService.createCourceWithChat(createCourceDto);
    }

    @GetMapping("/{id}")
    public CourceDto getCourceById(@PathVariable("id") Integer id) {
        return courceService.getCourceById(id);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<CourceDto> editCource(@PathVariable("id") Integer id,
                                                EditCourceDto editCourceDto) {
        return new ResponseEntity<>(courceService.editCource(id, editCourceDto), HttpStatus.OK);
    }
}
