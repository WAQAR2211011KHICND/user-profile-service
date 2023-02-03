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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xloop.resourceloop.candidateprofile.model.CandidateSkills;
import com.xloop.resourceloop.candidateprofile.service.CandidateSkillsService;

@RestController
@CrossOrigin
@RequestMapping("/api/users/skills")
public class CandidateSkillsController {
    @Autowired
    public CandidateSkillsService service;

    @PostMapping("")
    public ResponseEntity<CandidateSkills> create(@RequestBody CandidateSkills skill){
        CandidateSkills createdSkill= service.create(skill);
        return new ResponseEntity<>(createdSkill, HttpStatus.CREATED);
    }

    @GetMapping("/{userId}")
    public List<CandidateSkills> get_skills(@PathVariable long userId){
        return service.get_all_skills_of_user(userId);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        CandidateSkills existedSkill= service.get_skill_by_id(id);
        if(existedSkill==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
