package org.education.controller;

import org.education.dto.cource.CourceDto;
import org.education.dto.cource.CreateCourceDto;
import org.education.dto.cource.EditCourceDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cource")
public class CourceController {

    @PostMapping("/create")
    public Integer createCourceWithChat(CreateCourceDto createCource) {
        return null;
    }

    @GetMapping("/{id}")
    public CourceDto getCourceById(@PathVariable("id") Integer id) {
        return null;
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<CourceDto> editCource(@PathVariable("id") Integer id,
                                                EditCourceDto editCource) {
        return null;
    }
}
