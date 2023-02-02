package com.xloop.resourceloop.candidateprofile.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xloop.resourceloop.candidateprofile.model.CandidateAcademicInfo;
import com.xloop.resourceloop.candidateprofile.repository.ICandidateAcademicInfoRepository;


@Service
public class CandidateAcademicInfoService {
    @Autowired
    public ICandidateAcademicInfoRepository academicInfoRepo;

    public CandidateAcademicInfo createAcademicInformation(CandidateAcademicInfo academicInfo){
        return academicInfoRepo.save(academicInfo);
    }
    
    public CandidateAcademicInfo getAcademicInformationById(Long id) {
        return academicInfoRepo.findById(id).orElse(null);
    }

    // getAcademicInformationByUserId

    public List<CandidateAcademicInfo> getAcademicInformationByUserId(Long userId) {
        return academicInfoRepo.findAllByUserId(userId);
    }

    // get all information
    public List<CandidateAcademicInfo> getAllAcademicInformation(){
        return academicInfoRepo.findAll();
    }

    public CandidateAcademicInfo updateAcademicInformation(Long id, CandidateAcademicInfo academicInformation){
        Optional<CandidateAcademicInfo> academicInformationOptional = academicInfoRepo.findById(id);
        if(academicInformationOptional.isPresent()) {
            CandidateAcademicInfo existingAcademicInformation = academicInformationOptional.get();
            existingAcademicInformation.setCurrentDegree(academicInformation.getCurrentDegree());
            existingAcademicInformation.setUserId(academicInformation.getUserId());
            existingAcademicInformation.setCgpa(academicInformation.getCgpa());
            // existingAcademicInformation.setCertificates(academicInformation.getCertificates());
            existingAcademicInformation.setTitle(academicInformation.getTitle());
            existingAcademicInformation.setInstitute(academicInformation.getInstitute());
            existingAcademicInformation.setFinalYearProject(academicInformation.getFinalYearProject());
            existingAcademicInformation.setDegreeProgress(academicInformation.getDegreeProgress());
            existingAcademicInformation.setGraduationDate(academicInformation.getGraduationDate());
            academicInfoRepo.save(existingAcademicInformation);
            return existingAcademicInformation;
        }
        else {
            return null;
        }
    }

    public void deleteAcademicInformation(Long id) {
        academicInfoRepo.deleteById(id);
    }

}
