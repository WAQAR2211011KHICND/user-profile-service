package com.xloop.resourceloop.candidateprofile;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

// import org.apache.tomcat.util.http.parser.MediaType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.autoconfigure.web.WebProperties.Resources.Chain.Strategy.Content;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xloop.resourceloop.candidateprofile.controller.CandiadateWorkExperienceController;
import com.xloop.resourceloop.candidateprofile.model.CandidateWorkExperienceInfo;
import com.xloop.resourceloop.candidateprofile.service.CandidateWorkExperienceInfoService;

@SpringBootTest
class WorkExperienceApplicationTests {

	private MockMvc mvc;

	@Mock
	private CandidateWorkExperienceInfoService workExperienceService;

	@InjectMocks
	private CandiadateWorkExperienceController controller;

	private JacksonTester<CandidateWorkExperienceInfo> json;
	private JacksonTester<Collection<CandidateWorkExperienceInfo>> jsonList;

	@BeforeEach
	public void setUp() {
		JacksonTester.initFields(this, new ObjectMapper());
		mvc = MockMvcBuilders.standaloneSetup(controller).build();

	}

	@Test
	void contextLoads() {
	}

	// post method test
	@Test
	public void canCreateWorkExperienceInfo() throws Exception {
		CandidateWorkExperienceInfo info1 = new CandidateWorkExperienceInfo(1L, 2L,"ABC","Yes",null, null,"Project Manager", "Full Time"
				);
		when(workExperienceService.createWorkExperience(info1)).thenReturn(info1);
		mvc.perform(post("/api/work_experience")
				.contentType(MediaType.APPLICATION_JSON)
				.content(json.write(info1).getJson()))
				.andExpect(status().isCreated());
		// .andExpect(content().json(json.write(info1).getJson()));
	}

	// Get all information
	@Test
	public void getWorkExperience() throws Exception {
		CandidateWorkExperienceInfo getInfo1 = new CandidateWorkExperienceInfo(1L, 2L,"ABC","Yes",null, null,"Project Manager", "Full Time");
		CandidateWorkExperienceInfo getInfo2 = new CandidateWorkExperienceInfo(1L, 2L,"ABC","Yes",null, null,"Project Manager", "Full Time");
		List<CandidateWorkExperienceInfo> WEL = new ArrayList<CandidateWorkExperienceInfo>();
		WEL.add(getInfo1);
		WEL.add(getInfo2);
		when(workExperienceService.getWorkExperience()).thenReturn(WEL);
		mvc.perform(get("/api/work_experience")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().json(jsonList.write(WEL).getJson()));
	}

	// get information by ID
	@Test
	public void getWorkExperienceById() throws Exception {
		CandidateWorkExperienceInfo getInfoById1 = new CandidateWorkExperienceInfo(1L, 2L,"ABC","Yes",null, null,"Project Manager", "Full Time");
		when(workExperienceService.getWorkExperienceById(2L)).thenReturn(getInfoById1);
		mvc.perform(get("/api/work_experience/2")
				.contentType(MediaType.APPLICATION_JSON)
				.content(json.write(getInfoById1).getJson()))
				.andExpect(status().isOk())
				.andExpect(content().json(json.write(getInfoById1).getJson()));

	}

	// get information by user ID
	@Test
	public void getWorkExperienceByUserId() throws Exception {
		CandidateWorkExperienceInfo getinfoByUserIdObj1 = new CandidateWorkExperienceInfo(
			1L, 2L,"ABC","Yes",null, null,"Project Manager", "Full Time");

		CandidateWorkExperienceInfo getinfoByUserIdObj2 = new CandidateWorkExperienceInfo
			(1L, 2L,"ABC","Yes",null, null,"Project Manager", "Full Time");

		List<CandidateWorkExperienceInfo> WEL = new ArrayList<CandidateWorkExperienceInfo>();
		WEL.add(getinfoByUserIdObj1);
		WEL.add(getinfoByUserIdObj2);
		when(workExperienceService.getWorkExperienceByUserId(50L)).thenReturn(WEL);

		mvc.perform(get("/api/work_experience/user/50")
		.contentType(MediaType.APPLICATION_JSON)
		.content(jsonList.write(WEL).getJson()))
		.andExpect(status().isOk())
		.andExpect(content().json(jsonList.write(WEL).getJson()));
	}

	// UPDATE information by ID
	
	@Test
	public void updateWorkExperience() throws Exception {
		CandidateWorkExperienceInfo updateInfoObJ = new CandidateWorkExperienceInfo
			(1L, 2L,"ABC","Yes",null, null,"Project Manager", "Full Time");
			when(workExperienceService.updateWorkExperience(eq(1L), any(CandidateWorkExperienceInfo.class) )).thenReturn(updateInfoObJ);
		mvc.perform(put("/api/work_experience/1")
				.contentType(MediaType.APPLICATION_JSON)
				.content(json.write(updateInfoObJ).getJson()))
				.andExpect(status().isOk())
				.andExpect(content().json(json.write(updateInfoObJ).getJson()));
			} 

	// Delete Information 
	// @Test
	// public void deleteWorkExperience() throws Exception {
	// 	CandidateWorkExperienceInfo deleteWorkExpObj = new CandidateWorkExperienceInfo(1L, 2L,"ABC","Yes",null, null,"Project Manager", "Full Time");
	// 	when(workExperienceService.deleteWorkExperience(1L)).thenReturn(deleteWorkExpObj);
	// 	mvc.perform(delete("/api/work_experience/1"))
	// 	.andExpect(status().isNoContent());
	// }

	@Test
	public void deleteWorkExperience() throws Exception {
		CandidateWorkExperienceInfo info = new CandidateWorkExperienceInfo(1L, 2L,"ABC","Yes",null, null,"Project Manager", "Full Time");
		when(workExperienceService.getWorkExperienceById(1L)).thenReturn(info);
		mvc.perform(delete("/api/work_experience/1"))
			.andExpect(status().isNoContent());
		}

}
