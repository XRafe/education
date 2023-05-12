package org.education.repository;

import org.education.entity.StageResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StageResultRepository extends JpaRepository<StageResult, Integer> {

    boolean existsByUserIdAndStageId(Integer userId, Integer stageId);

    StageResult findByUserIdAndStageId(Integer userId, Integer stageId);
}
