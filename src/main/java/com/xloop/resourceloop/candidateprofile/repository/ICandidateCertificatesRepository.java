package com.xloop.resourceloop.candidateprofile.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xloop.resourceloop.candidateprofile.model.CandidateCertificates;

@Repository
public interface ICandidateCertificatesRepository extends  JpaRepository<CandidateCertificates, Long>{
    public List<CandidateCertificates> findAllByUserId(Long userId);
    

}
