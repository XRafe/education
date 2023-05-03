package org.education.repository.criteria;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import lombok.RequiredArgsConstructor;
import org.education.dto.cource.CourceDto;
import org.education.dto.cource.SubscribeCourceDto;
import org.education.entity.Cource;
import org.education.entity.User;
import org.education.entity.UserCources;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CourceCriteriaRepository {

    private final EntityManager em;

    public List<SubscribeCourceDto> getListSubscribeUser(Integer userId) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<UserCources> cq = cb.createQuery(UserCources.class);
        Root<UserCources> root = cq.from(UserCources.class);

        Join<UserCources, User> joinUser = root.join("user", JoinType.INNER);
        Join<UserCources, Cource> joinCource = root.join("cource", JoinType.INNER);

        Predicate userIdPredicate = cb.equal(root.get("userId"), userId);
        cq.where(userIdPredicate);

        cq.select(root);
        cq.distinct(true);

        TypedQuery<UserCources> userCources = em.createQuery(cq);
        return userCources.getResultList()
                .stream()
                .map(m -> new SubscribeCourceDto(
                m.getCourceId(),
                m.getCource().getTitle(),
                m.getCource().getImageUrl(),
                m.getCource().getRating(),
                m.getScores()
        )).toList();
    }
}
