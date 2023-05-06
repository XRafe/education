package org.education.service.impl;

import lombok.RequiredArgsConstructor;
import org.education.dto.chat.ChatDto;
import org.education.entity.Chat;
import org.education.entity.User;
import org.education.repository.ChatRepository;
import org.education.repository.UserRepository;
import org.education.repository.criteria.ChatCriteriaRepository;
import org.education.service.ChatService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatServiceImpl implements ChatService {

    private final ChatRepository chatRepository;
    private final UserRepository userRepository;
    private final ChatCriteriaRepository chatCriteriaRepository;

    @Override
    public Integer createChat(Integer courceId) {
        Chat chat = new Chat(courceId);

        chat = chatRepository.saveAndFlush(chat);

        return chat.getId();
    }

    @Override
    public List<ChatDto> getAllByUserId(String email) {
        User user = userRepository.findByEmail(email).orElseThrow();

        return chatCriteriaRepository.getAllByUserId(user.getId());
    }
}
