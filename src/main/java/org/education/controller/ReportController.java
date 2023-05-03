package org.education.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.education.cookie.ActionWithCookie;
import org.education.dto.report.CreateReportDto;
import org.education.dto.report.ReportDto;
import org.education.jwt.ActionWithJwt;
import org.education.service.ReportService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ReportController {

    private final ReportService reportService;
    private final ActionWithJwt actionWithJwt;
    private final ActionWithCookie actionWithCookie;

    @PostMapping("/cource/{courceId}/report/create")
    public ResponseEntity<ReportDto> createReport(HttpServletRequest httpServletRequest,
                                                  @PathVariable("courceId") Integer courceId,
                                                  CreateReportDto createReportDto) {
        String token = actionWithCookie.getTokenFromRequest(httpServletRequest);
        String email = actionWithJwt.getEmailByToken(token);

        return new ResponseEntity<>(reportService.createReport(courceId, createReportDto, email), HttpStatus.OK);
    }

    @GetMapping("/cource/{courceId}/report/list")
    public List<ReportDto> getReportsByCourceId(@PathVariable("courceId") Integer courceId) {
        return reportService.getReportsByCourceId(courceId);
    }
}
