package com.xloop.resourceloop.candidateprofile.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xloop.resourceloop.candidateprofile.model.CandidateWorkExperienceInfo;
import com.xloop.resourceloop.candidateprofile.service.CandidateWorkExperienceInfoService;


@CrossOrigin
@RestController
@RequestMapping("/api/work_experience")
public class CandiadateWorkExperienceController {
    
    @Autowired
    public CandidateWorkExperienceInfoService workExperienceInfoService;

    @PostMapping("")
    public ResponseEntity<CandidateWorkExperienceInfo> createWorkExp(
        @RequestBody CandidateWorkExperienceInfo workExp ){
            CandidateWorkExperienceInfo craetedWorkExperience = workExperienceInfoService.createWorkExperience(workExp);
            return new ResponseEntity<>(craetedWorkExperience, HttpStatus.CREATED);
        }

        @GetMapping("")
        public List<CandidateWorkExperienceInfo> getAllWorkExperienceInformation() {
            return workExperienceInfoService.getWorkExperience();
        }
    
        @GetMapping("/{id}")
        public ResponseEntity<CandidateWorkExperienceInfo> getWorkExperienceById(@PathVariable Long id) {
            CandidateWorkExperienceInfo academicInformation = workExperienceInfoService.getWorkExperienceById(id);
            if (academicInformation == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<CandidateWorkExperienceInfo>(academicInformation, HttpStatus.OK);
        }
    
        @GetMapping("/user/{userId}")
        public ResponseEntity<List<CandidateWorkExperienceInfo>> getWorkExperienceByUserId(@PathVariable Long userId) {
            List<CandidateWorkExperienceInfo> academicInformation = workExperienceInfoService.getWorkExperienceByUserId(userId);
            if (academicInformation == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<List<CandidateWorkExperienceInfo>>(academicInformation, HttpStatus.OK);
        }
    
        @PutMapping("/{id}")
        public ResponseEntity<CandidateWorkExperienceInfo> updateWorkExperience(@PathVariable Long id,
                @RequestBody CandidateWorkExperienceInfo academicInfotmation) {
                    CandidateWorkExperienceInfo updatedAcademicInformation = workExperienceInfoService.updateWorkExperience(id,
                    academicInfotmation);
            if (updatedAcademicInformation == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    
            } else {
                return new ResponseEntity<CandidateWorkExperienceInfo>(updatedAcademicInformation, HttpStatus.OK);
            }
        }
    
        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteWorkExperience(@PathVariable Long id) {
            CandidateWorkExperienceInfo workExperienceInformation = workExperienceInfoService.getWorkExperienceById(id);
            if (workExperienceInformation == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            } else {
                workExperienceInfoService.deleteWorkExperience(id);
                System.out.println("data deleted successfully");
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        }

}
