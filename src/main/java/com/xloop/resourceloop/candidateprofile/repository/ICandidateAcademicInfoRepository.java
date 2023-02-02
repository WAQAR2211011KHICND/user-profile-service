package com.xloop.resourceloop.candidateprofile.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xloop.resourceloop.candidateprofile.model.CandidateAcademicInfo;

public interface ICandidateAcademicInfoRepository extends JpaRepository<CandidateAcademicInfo,Long> {

    public List<CandidateAcademicInfo> findAllByUserId(Long userId);
}
