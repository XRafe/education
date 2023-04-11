package org.education.controller;

import org.education.dto.report.CreateReportDto;
import org.education.dto.report.ReportDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cource/report")
public class ReportController {

    @PostMapping("/create")
    public ResponseEntity<ReportDto> createReport(CreateReportDto createReport) {
        return null;
    }

    @GetMapping("/{id}")
    public ReportDto getReportsByCourceId(@PathVariable("id") Integer id) {
        return null;
    }
}
