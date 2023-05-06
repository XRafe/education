package org.education.dto.message;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class MessageDto {

    private final Integer id;
    private final String text;
    private final Integer userId;
    private final String userName;

}
