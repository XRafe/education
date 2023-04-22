package org.education.service.impl;

import lombok.RequiredArgsConstructor;
import org.education.dto.report.CreateReportDto;
import org.education.dto.report.ReportDto;
import org.education.entity.Cource;
import org.education.entity.Report;
import org.education.repository.CourceRepository;
import org.education.repository.ReportRepository;
import org.education.service.ReportService;
import org.education.service.mapper.ReportMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService {

    private final ReportRepository reportRepository;
    private final CourceRepository courceRepository;
    private final ReportMapper reportMapper;

    @Override
    public ReportDto createReport(Integer courceId, CreateReportDto createReportDto) {
        Report report = new Report(
                createReportDto.getText(),
                createReportDto.getRating()
        );

        Cource cource = courceRepository.findById(courceId).orElseThrow();
        report.setCource(cource);

        report = reportRepository.saveAndFlush(report);

        return reportMapper.mapReportToReportDto(report);
    }

    @Override
    public ReportDto getReportsByCourceId(Integer id) {
        Report report = reportRepository.findById(id).orElseThrow();
        return reportMapper.mapReportToReportDto(report);
    }
}
