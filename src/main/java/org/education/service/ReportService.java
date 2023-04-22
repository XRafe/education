package org.education.service;

import org.education.dto.report.CreateReportDto;
import org.education.dto.report.ReportDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface ReportService {
    ReportDto createReport(CreateReportDto createReport);

    ReportDto getReportsByCourceId(Integer id);
}
