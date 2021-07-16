package com.asusoftware.ReditClone.repository;

import com.asusoftware.ReditClone.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface VoteRepository extends JpaRepository<Vote, Long> {
}
