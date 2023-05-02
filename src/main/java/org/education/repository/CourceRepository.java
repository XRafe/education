package org.education.repository;

import org.education.entity.Cource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourceRepository extends JpaRepository<Cource, Integer> {
    List<Cource> findAllByUserId(Integer userId);
}
