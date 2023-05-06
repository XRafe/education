package org.education.repository;

import org.education.entity.UserCources;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserCourcesRepository extends JpaRepository<UserCources, Integer> {

    Optional<UserCources> findByUserIdAndCourceId(Integer userId, Integer courceId);

    boolean existsByUserIdAndCourceId(Integer userId, Integer courceId);
}
