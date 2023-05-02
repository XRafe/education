package org.education.service;

import java.util.List;

public interface MessageService {

    void sendMessage(Integer chatId, String userEmail, String text);

    List<String> getListMessage(Integer chatId);
}
