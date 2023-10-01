package com.stepbros.skillwise.reward;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RewardClaimedRepository extends JpaRepository<RewardClaimed, Long> {
}
