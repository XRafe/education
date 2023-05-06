package org.education.service.impl;

import lombok.RequiredArgsConstructor;
import org.education.dto.message.MessageDto;
import org.education.entity.Chat;
import org.education.entity.Message;
import org.education.entity.User;
import org.education.repository.ChatRepository;
import org.education.repository.MessageRepository;
import org.education.repository.UserRepository;
import org.education.repository.criteria.MessageCriteriaRepository;
import org.education.service.MessageService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {

    private final ChatRepository chatRepository;
    private final MessageRepository messageRepository;
    private final UserRepository userRepository;
    private final MessageCriteriaRepository messageCriteriaRepository;

    @Override
    public void sendMessage(Integer chatId, String userEmail, String text) {
        Chat chat = chatRepository.findById(chatId).orElseThrow();
        User user = userRepository.findByEmail(userEmail).orElseThrow();

        Message message = new Message(
                text,
                user.getId(),
                chat.getId());

        messageRepository.saveAndFlush(message);
    }

    @Override
    public List<MessageDto> getListMessage(Integer chatId) {
        List<Message> messageList = messageCriteriaRepository.getAllByChatId(chatId);
        return messageList.stream()
                .map(m -> new MessageDto(
                        m.getId(),
                        m.getText(),
                        m.getUser().getId(),
                        m.getUser().getName()
                )).toList();
    }
}
