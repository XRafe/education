package org.education.dto.stage;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class StageDto {

    private final Integer id;
    private final String title;

    private final String info;

    private final String data;

    private final String type;

    private final Integer score;
}
