package org.education.service.mapper;

import org.education.dto.report.ReportDto;
import org.education.entity.Report;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

@Component
public class ReportMapper {

    public ReportDto mapReportToReportDto(Report report) {
        return new ReportDto(
                report.getId(),
                report.getText(),
                report.getRating(),
                report.getCreatedAt(),
                report.getUser().getName()
        );
    }

    public List<ReportDto> mapReportToReportDto(Collection<Report> reports) {
        return reports.stream()
                .map(this::mapReportToReportDto)
                .toList();
    }
}
