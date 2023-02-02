package com.xloop.resourceloop.candidateprofile.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xloop.resourceloop.candidateprofile.model.CandidateWorkExperienceInfo;



public interface ICandidateWorkExperienceRepository extends JpaRepository<CandidateWorkExperienceInfo, Long> {

    public List<CandidateWorkExperienceInfo> findAllByUserId(Long userId);
    
}
