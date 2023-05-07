package org.education.dto.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class SendMessageDto {

    private final Integer chatId;
    private final String text;

    public SendMessageDto(@JsonProperty("chatId") Integer chatId,
                          @JsonProperty("text") String text) {
        this.chatId = chatId;
        this.text = text;
    }
}
