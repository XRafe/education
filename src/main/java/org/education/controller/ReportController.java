package org.education.controller;

import lombok.RequiredArgsConstructor;
import org.education.dto.report.CreateReportDto;
import org.education.dto.report.ReportDto;
import org.education.service.ReportService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cource/report")
@RequiredArgsConstructor
public class ReportController {

    private final ReportService reportService;

    @PostMapping("/create")
    public ResponseEntity<ReportDto> createReport(CreateReportDto createReportDto) {
        return new ResponseEntity<>(reportService.createReport(createReportDto), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ReportDto getReportsByCourceId(@PathVariable("id") Integer id) {
        return reportService.getReportsByCourceId(id);
    }
}
