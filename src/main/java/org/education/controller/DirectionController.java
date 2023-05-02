package org.education.controller;

import lombok.RequiredArgsConstructor;
import org.education.service.DirectionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/direction")
@RequiredArgsConstructor
public class DirectionController {

    private final DirectionService directionService;

    @GetMapping("/list")
    public List<String> getList() {
        return directionService.getListDirection();
    }
}
