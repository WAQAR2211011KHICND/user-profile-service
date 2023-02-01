package com.xloop.resourceloop.candidateprofile.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xloop.resourceloop.candidateprofile.model.CandidatePersonalInfo;
import com.xloop.resourceloop.candidateprofile.model.CandidateWorkExperience;

@Repository
public interface ICandidateWorkExperienceRepository extends JpaRepository<CandidateWorkExperience, Long>{
    // public CandidatePersonalInfo findByUserId(Long userId);
}
