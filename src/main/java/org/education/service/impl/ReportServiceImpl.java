package org.education.service.impl;

import lombok.RequiredArgsConstructor;
import org.education.dto.report.CreateReportDto;
import org.education.dto.report.ReportDto;
import org.education.entity.Cource;
import org.education.entity.Report;
import org.education.entity.User;
import org.education.repository.CourceRepository;
import org.education.repository.ReportRepository;
import org.education.repository.UserRepository;
import org.education.service.ReportService;
import org.education.service.mapper.ReportMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService {

    private final ReportRepository reportRepository;
    private final CourceRepository courceRepository;
    private final ReportMapper reportMapper;
    private final UserRepository userRepository;

    @Transactional
    @Override
    public ReportDto createReport(Integer courceId, CreateReportDto createReportDto, String emailUser) {
        User user = userRepository.findByEmail(emailUser).orElseThrow();
        Report report = new Report(
                createReportDto.getText(),
                createReportDto.getRating(),
                user.getId(),
                courceId
        );

        report = reportRepository.saveAndFlush(report);

        AtomicInteger rating = new AtomicInteger();

        List<Report> list = reportRepository.findAllByCourceId(courceId);
        list.forEach(m -> rating.addAndGet(m.getRating()));

        int finalRaiting = rating.get() / list.size();

        Cource cource = courceRepository.findById(courceId).orElseThrow();
        cource.setRating(finalRaiting);

        courceRepository.saveAndFlush(cource);

        return reportMapper.mapReportToReportDto(report);
    }

    @Override
    public List<ReportDto> getReportsByCourceId(Integer courceId) {
        List<Report> list = reportRepository.findAllByCourceId(courceId);
        return reportMapper.mapReportToReportDto(list);
    }
}
