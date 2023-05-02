package org.education.dto.module;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ModuleDto {

    private final Integer id;
    private final String title;
    private final String info;
    private final Integer score;

}
