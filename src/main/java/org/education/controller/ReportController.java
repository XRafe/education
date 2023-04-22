package org.education.controller;

import lombok.RequiredArgsConstructor;
import org.education.dto.report.CreateReportDto;
import org.education.dto.report.ReportDto;
import org.education.service.ReportService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ReportController {

    private final ReportService reportService;

    @PostMapping("/cource/{courceId}/report/create")
    public ResponseEntity<ReportDto> createReport(@PathVariable("courceId") Integer courceId, CreateReportDto createReportDto) {
        return new ResponseEntity<>(reportService.createReport(courceId, createReportDto), HttpStatus.OK);
    }

    @GetMapping("/cource/report/{id}/edit")
    public ReportDto getReportsByCourceId(@PathVariable("id") Integer id) {
        return reportService.getReportsByCourceId(id);
    }
}
