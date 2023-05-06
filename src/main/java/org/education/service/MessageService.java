package org.education.service;

import org.education.dto.message.MessageDto;

import java.util.List;

public interface MessageService {

    void sendMessage(Integer chatId, String userEmail, String text);

    List<MessageDto> getListMessage(Integer chatId);
}
