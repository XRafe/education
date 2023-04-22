package org.education.dto.module;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ModuleDto {

    private final String title;

    private final String info;

    private final String score;
}
