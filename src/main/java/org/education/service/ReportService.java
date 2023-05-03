package org.education.service;

import org.education.dto.report.CreateReportDto;
import org.education.dto.report.ReportDto;

import java.util.List;

public interface ReportService {
    ReportDto createReport(Integer courceId, CreateReportDto createReport, String emailUser);

    List<ReportDto> getReportsByCourceId(Integer courceId);
}
