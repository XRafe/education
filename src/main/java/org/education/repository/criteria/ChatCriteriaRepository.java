package org.education.repository.criteria;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import lombok.RequiredArgsConstructor;
import org.education.dto.chat.ChatDto;
import org.education.entity.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ChatCriteriaRepository {

    private final EntityManager em;

    public List<ChatDto> getAllByUserId(Integer userId) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<UserCources> cq = cb.createQuery(UserCources.class);

        Root<UserCources> root = cq.from(UserCources.class);

        Join<UserCources, Cource> userCourcesCourceJoin = root.join("cource", JoinType.INNER);
        Join<UserCources, User> userJoin = root.join("user", JoinType.INNER);
        Join<Cource, Chat> chatJoin = userCourcesCourceJoin.join("chat", JoinType.INNER);
        Join<Chat, Message> messageJoin = chatJoin.join("messages", JoinType.INNER);

        Predicate predicate = cb.equal(root.get("userId"), userId);

        cq.where(predicate);
        cq.distinct(true);

        TypedQuery<UserCources> result = em.createQuery(cq);
        return result.getResultStream().map(m -> new ChatDto(
                m.getCource().getChat().getId(),
                m.getCourceId(),
                m.getCource().getTitle(),
                m.getCource().getImageUrl(),
                m.getCource().getChat()
                        .getMessages()
                        .stream().map(c -> c.getText())
                        .reduce((first, second) -> second).orElse(null)
        )).toList();
    }
}
