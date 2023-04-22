package org.education.service.mapper;

import org.education.dto.report.ReportDto;
import org.education.entity.Report;
import org.springframework.stereotype.Component;

@Component
public class ReportMapper {

    public ReportDto mapReportToReportDto(Report report) {
        return new ReportDto(
                report.getText(),
                report.getRating(),
                report.getCreatedAt()
        );
    }
}
