package org.education.repository.criteria;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import lombok.RequiredArgsConstructor;
import org.education.entity.Cource;
import org.education.entity.Module;
import org.education.entity.User;
import org.education.entity.UserCources;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ModuleCriteriaRepository {

    private final EntityManager em;

    public List<Module> getAllByCourceIdAndUserId(Integer courceId, Integer userId) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Module> cq = cb.createQuery(Module.class);
        Root<Module> root = cq.from(Module.class);

        Join<Module, Cource> courceJoin = root.join("cource", JoinType.INNER);
        Join<UserCources, Cource> userCourcesCourceJoin = courceJoin.join("userCources", JoinType.INNER);
        Join<UserCources, User> userJoin = userCourcesCourceJoin.join("user", JoinType.INNER);

        Predicate userPredicate = cb.equal(userCourcesCourceJoin.get("userId"), userId);
        Predicate courcePredicate = cb.equal(root.get("courceId"), courceId);

        cq.where(userPredicate).where(courcePredicate);
        cq.distinct(true);

        TypedQuery<Module> result = em.createQuery(cq);

        return result.getResultList();
    }
}
