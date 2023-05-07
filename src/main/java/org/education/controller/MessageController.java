package org.education.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.education.cookie.ActionWithCookie;
import org.education.dto.message.MessageDto;
import org.education.dto.message.SendMessageDto;
import org.education.jwt.ActionWithJwt;
import org.education.service.MessageService;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MessageController {

    private final MessageService messageService;
    private final ActionWithJwt actionWithJwt;
    private final ActionWithCookie actionWithCookie;
    private final SimpMessagingTemplate simpMessagingTemplate;

    @PostMapping("/chat")
    public void sendMessage(HttpServletRequest httpServletRequest,
                            @RequestBody SendMessageDto sendMessageDto) {
        String token = actionWithCookie.getTokenFromRequest(httpServletRequest);
        String email = actionWithJwt.getEmailByToken(token);
        messageService.sendMessage(sendMessageDto.getChatId(), email, sendMessageDto.getText());
    }

    @GetMapping("/chat/{chatId}")
    public List<MessageDto> getListMessage(@PathVariable("chatId") Integer chatId) {
        return messageService.getListMessage(chatId);
    }

    @MessageMapping("/chat")
    public void sendMessageToChat(@Payload SendMessageDto sendMessageDto) {
        List<MessageDto> list = messageService.getListMessage(sendMessageDto.getChatId());

        simpMessagingTemplate
                .convertAndSendToUser(
                        sendMessageDto.getChatId().toString(),
                        "/list",
                        list.get(list.size() - 1));
    }
}
