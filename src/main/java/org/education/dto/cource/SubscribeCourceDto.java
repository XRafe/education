package org.education.dto.cource;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class SubscribeCourceDto {
    private final Integer id;
    private final String title;
    private final String imageUrl;
    private final Integer rating;
    private final Integer scores;
}
