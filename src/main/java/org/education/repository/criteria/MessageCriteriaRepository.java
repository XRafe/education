package org.education.repository.criteria;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import lombok.RequiredArgsConstructor;
import org.education.entity.Message;
import org.education.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MessageCriteriaRepository {

    private final EntityManager em;

    public List<Message> getAllByChatId(Integer chatId) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Message> cq = cb.createQuery(Message.class);
        Root<Message> root = cq.from(Message.class);

        Join<Message, User> userJoin = root.join("user", JoinType.INNER);
        Predicate chatPredicate = cb.equal(root.get("chatId"), chatId);

        cq.where(chatPredicate);
        cq.distinct(true);

        TypedQuery<Message> result = em.createQuery(cq);
        return result.getResultList();
    }
}
