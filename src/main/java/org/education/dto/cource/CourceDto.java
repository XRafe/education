package org.education.dto.cource;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CourceDto {

    private final String title;

    private final String info;

    private final String imageUrl;

    private final String usersCount;

    private final String rating;

    private final String direction;
}
