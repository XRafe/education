package org.education.service.impl;

import lombok.RequiredArgsConstructor;
import org.education.entity.Chat;
import org.education.repository.ChatRepository;
import org.education.service.ChatService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatServiceImpl implements ChatService {

    private final ChatRepository chatRepository;

    @Override
    public Integer createChat(Integer courceId) {
        Chat chat = new Chat(courceId);

        chat = chatRepository.saveAndFlush(chat);

        return chat.getId();
    }
}
