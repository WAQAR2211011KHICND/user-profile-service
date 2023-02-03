package com.xloop.resourceloop.candidateprofile.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xloop.resourceloop.candidateprofile.model.CandidateSkills;

@Repository
public interface ICandidateSkillsRepository extends JpaRepository<CandidateSkills, Long>{
    public List<CandidateSkills> findAllByUserId(Long userId);
}
