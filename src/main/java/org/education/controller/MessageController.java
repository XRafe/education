package org.education.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.education.cookie.ActionWithCookie;
import org.education.dto.message.MessageDto;
import org.education.jwt.ActionWithJwt;
import org.education.service.MessageService;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MessageController {

    private final MessageService messageService;
    private final ActionWithJwt actionWithJwt;
    private final ActionWithCookie actionWithCookie;

    @PostMapping("/chat/{chatId}")
    public void sendMessage(HttpServletRequest httpServletRequest, Integer chatId, String text) {
        String token = actionWithCookie.getTokenFromRequest(httpServletRequest);
        String email = actionWithJwt.getEmailByToken(token);
        messageService.sendMessage(chatId, email, text);
    }

    @GetMapping("/chat/{chatId}")
    public List<MessageDto> getListMessage(@PathVariable("chatId") Integer chatId) {
        return messageService.getListMessage(chatId);
    }
}
