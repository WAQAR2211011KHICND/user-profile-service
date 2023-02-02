package com.xloop.resourceloop.candidateprofile.controller;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.xloop.resourceloop.candidateprofile.model.CandidateWorkExperience;
import com.xloop.resourceloop.candidateprofile.service.CandidateWorkExperienceService;

@SpringBootTest
@AutoConfigureJsonTesters
@AutoConfigureMockMvc
public class CandidateWorkExperienceTests {
    
   private MockMvc mockMcv;
   private CandidateWorkExperience candWorkExperience;

   @Mock
   private CandidateWorkExperienceService workExperienceService;

   @InjectMocks
   private CandidateWorkExperienceController workExperienceController;

   


}
