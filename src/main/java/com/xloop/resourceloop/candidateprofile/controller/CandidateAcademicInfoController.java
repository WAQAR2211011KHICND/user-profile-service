package com.xloop.resourceloop.candidateprofile.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xloop.resourceloop.candidateprofile.model.CandidateAcademicInfo;
import com.xloop.resourceloop.candidateprofile.model.CandidatePersonalInfo;
import com.xloop.resourceloop.candidateprofile.service.CandidateAcademicInfoService;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@RestController
@RequestMapping("/api/educational_information")
public class CandidateAcademicInfoController {
    
    @Autowired
    public CandidateAcademicInfoService academicInfoService;
    
    @PostMapping("")
    public String createAcademicInformation( @RequestBody CandidateAcademicInfo academicInformation) 
    {
            // CandidateAcademicInfo createdAcademicInformation = academicInfoService.createAcademicInformation(academicInformation);
            // return new ResponseEntity<CandidateAcademicInfo>(createdAcademicInformation, HttpStatus.CREATED); 
            return "samra";
         }
        
    @GetMapping("")
    public String getAllAcademicInformation(){
        // return academicInfoService.getAllAcademicInformation();
        return "samra";
    }

    @GetMapping("/{id}")
    public ResponseEntity<CandidateAcademicInfo> getAcademicInformationById(@PathVariable Long id){
        CandidateAcademicInfo academicInformation = academicInfoService.getAcademicInformationById(id);
        if (academicInformation == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<CandidateAcademicInfo>(academicInformation, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CandidateAcademicInfo> updateAcademicInformation(@PathVariable Long id,@RequestBody CandidateAcademicInfo academicInfotmation){
        CandidateAcademicInfo updatedAcademicInformation = academicInfoService.updateAcademicInformation(id, academicInfotmation);
        if(updatedAcademicInformation == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
        else{
            return new ResponseEntity<CandidateAcademicInfo>(updatedAcademicInformation, HttpStatus.OK);
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAcademicInformation(@PathVariable Long id){
        CandidateAcademicInfo academicInformation = academicInfoService.getAcademicInformationById(id);
        if(academicInformation == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else{
            academicInfoService.deleteAcademicInformation(id);
            System.out.println("data deleted successfully");
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    } 

}
