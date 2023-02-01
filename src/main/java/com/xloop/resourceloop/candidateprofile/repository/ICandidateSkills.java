package com.xloop.resourceloop.candidateprofile.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xloop.resourceloop.candidateprofile.model.CandidateSkills;

public interface ICandidateSkills extends JpaRepository<CandidateSkills,Long> {
    
}
