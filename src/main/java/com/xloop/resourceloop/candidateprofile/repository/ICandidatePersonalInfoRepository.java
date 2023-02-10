package com.xloop.resourceloop.candidateprofile.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xloop.resourceloop.candidateprofile.model.CandidatePersonalInfo;

import java.util.List;

@Repository
public interface ICandidatePersonalInfoRepository extends JpaRepository<CandidatePersonalInfo, Long> {
    public CandidatePersonalInfo findByUserId(Long userId);
    public List<CandidatePersonalInfo> findAllByUserIdIn(List<Long> userIds);
}
