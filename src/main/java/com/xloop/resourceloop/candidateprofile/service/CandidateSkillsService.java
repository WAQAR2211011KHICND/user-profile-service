package com.xloop.resourceloop.candidateprofile.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xloop.resourceloop.candidateprofile.model.CandidateSkills;
import com.xloop.resourceloop.candidateprofile.repository.ICandidateSkillsRepository;

@Service
public class CandidateSkillsService {

    @Autowired
    public ICandidateSkillsRepository skillRepo;
    
    public CandidateSkills create(CandidateSkills skill){
        return skillRepo.save(skill);
    }

    public CandidateSkills get_skill_by_id(Long id){
        return skillRepo.findById(id).orElse(null);
    }

    public List<CandidateSkills> get_all_skills_of_user(Long userId){
        return skillRepo.findAllByUserId(userId);
    }
    public void delete(Long id){
        skillRepo.deleteById(id);
    }
}
