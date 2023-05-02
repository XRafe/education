package org.education.service.impl;

import lombok.RequiredArgsConstructor;
import org.education.entity.Chat;
import org.education.entity.Cource;
import org.education.repository.ChatRepository;
import org.education.repository.CourceRepository;
import org.education.service.ChatService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatServiceImpl implements ChatService {

    private final ChatRepository chatRepository;
    private final CourceRepository courceRepository;

    @Override
    public Integer createChat(Integer courceId) {
        Cource cource = courceRepository.findById(courceId).orElseThrow();

        Chat chat = new Chat(cource.getId());

        chat = chatRepository.saveAndFlush(chat);

        return chat.getId();
    }
}
