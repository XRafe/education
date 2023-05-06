package org.education.service;

import org.education.dto.chat.ChatDto;

import java.util.List;

public interface ChatService {

    Integer createChat(Integer courceId);

    List<ChatDto> getAllByUserId(String email);
}
