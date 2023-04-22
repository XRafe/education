package org.education.dto.report;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.Instant;

@Getter
@RequiredArgsConstructor
public class ReportDto {
    private final String text;

    private final Integer rating;

    private final Instant createdAt;
}
