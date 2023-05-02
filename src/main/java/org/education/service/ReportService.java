package org.education.service;

import org.education.dto.report.CreateReportDto;
import org.education.dto.report.ReportDto;

public interface ReportService {
    ReportDto createReport(Integer courceId, CreateReportDto createReport, String emailUser);

    ReportDto getReportsByCourceId(Integer id);
}
