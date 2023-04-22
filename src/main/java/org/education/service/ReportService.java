package org.education.service;

import org.education.dto.report.CreateReportDto;
import org.education.dto.report.ReportDto;

public interface ReportService {
    ReportDto createReport(Integer courceId, CreateReportDto createReport);

    ReportDto getReportsByCourceId(Integer id);
}
