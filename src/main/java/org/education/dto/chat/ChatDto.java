package org.education.dto.chat;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ChatDto {

    private final Integer id;
    private final Integer courceId;

    private final String title;

    private final String imageSrc;

    private final String lastMessage;
}
