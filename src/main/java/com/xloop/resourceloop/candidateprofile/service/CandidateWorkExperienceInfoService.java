package com.xloop.resourceloop.candidateprofile.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xloop.resourceloop.candidateprofile.model.CandidateWorkExperienceInfo;
import com.xloop.resourceloop.candidateprofile.repository.ICandidateWorkExperienceRepository;

@Service
public class CandidateWorkExperienceInfoService {
    
    @Autowired
    public ICandidateWorkExperienceRepository workExprepo;
    
    public CandidateWorkExperienceInfo createWorkExperience(CandidateWorkExperienceInfo workExperience){
        return workExprepo.save(workExperience);
    }

    public CandidateWorkExperienceInfo getWorkExperienceById(Long id){
        return workExprepo.findById(id).orElse(null);
    }

    public List<CandidateWorkExperienceInfo> getWorkExperienceByUserId(Long userId){
        return workExprepo.findAllByUserId(userId);

    }

    public List<CandidateWorkExperienceInfo> getWorkExperience(){
        return workExprepo.findAll();

    }

    public CandidateWorkExperienceInfo updateWorkExperience(Long id, CandidateWorkExperienceInfo workExperience){
        Optional<CandidateWorkExperienceInfo> workExperienceOptional = workExprepo.findById(id);
        if(workExperienceOptional.isPresent()){
            CandidateWorkExperienceInfo existingWorkExperience =  workExperienceOptional.get();
            existingWorkExperience.setCompany(workExperience.getCompany());
            existingWorkExperience.setCurrentStatus(workExperience.getCurrentStatus());
            existingWorkExperience.setJobTitle(workExperience.getJobTitle());
            existingWorkExperience.setJobType(workExperience.getJobType());
            existingWorkExperience.setUserId(workExperience.getUserId());
            existingWorkExperience.setStartDate(workExperience.getStartDate());
            existingWorkExperience.setEndDate(workExperience.getEndDate());
            workExprepo.save(existingWorkExperience);
            return existingWorkExperience;
        }
        else{
            return null;
        }
    }
    

    public void deleteWorkExperience(Long id){
        workExprepo.deleteById(id);
    }


}
