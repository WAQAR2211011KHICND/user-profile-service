package com.xloop.resourceloop.candidateprofile;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xloop.resourceloop.candidateprofile.controller.CandidateAcademicInfoController;
import com.xloop.resourceloop.candidateprofile.model.CandidateAcademicInfo;
import com.xloop.resourceloop.candidateprofile.service.CandidateAcademicInfoService;

@AutoConfigureJsonTesters
@SpringBootTest
@AutoConfigureMockMvc
class UserAcdemicInformationApplicationTests {

	private MockMvc mvc;

	@Mock
	private CandidateAcademicInfoService academicInfoService;

	@InjectMocks
	private CandidateAcademicInfoController controller;

	private JacksonTester<CandidateAcademicInfo> json;
	private JacksonTester<Collection<CandidateAcademicInfo>> jsonList;

	@BeforeEach
	public void setUp() {
		JacksonTester.initFields(this, new ObjectMapper());
		mvc = MockMvcBuilders.standaloneSetup(controller).build();
	}

	@Test
	void contextLoads() {
	}

	@Test
	public void canGetAllCandidateAcademicInfo() throws Exception {
		CandidateAcademicInfo info1 = new CandidateAcademicInfo(1L, 2L, "Masters", "AP", "KU", "no", null, "3.4",
				"My cool FYP");
		CandidateAcademicInfo info2 = new CandidateAcademicInfo(1L, 2L, "Masters", "AP", "KU", "no", null, "3.4",
				"My cool FYP");
		List<CandidateAcademicInfo> academicInfo = new ArrayList<CandidateAcademicInfo>();
		academicInfo.add(info1);
		academicInfo.add(info2);
		when(academicInfoService.getAllAcademicInformation()).thenReturn(academicInfo);
		mvc.perform(get("/api/educational_information")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().json(jsonList.write(academicInfo).getJson()));

	}

	@Test
	public void canCreateCandidateAcademicInfo() throws Exception {
		CandidateAcademicInfo info1 = new CandidateAcademicInfo(1L, 2L, "Masters", "AP", "KU", "no", null, "3.4",
				"My cool FYP");
		when(academicInfoService.createAcademicInformation(info1)).thenReturn(info1);
		mvc.perform(post("/api/educational_information")
				.contentType(MediaType.APPLICATION_JSON)
				.content(json.write(info1).getJson()))
				.andExpect(status().isCreated());
		// .andExpect(content().json(json.write(info1).getJson()));

	}

	@Test
	public void canGetCandidateAcademicInfoById() throws Exception {
		CandidateAcademicInfo info = new CandidateAcademicInfo(1L, 2L, "Masters", "AP", "KU", "no", null, "3.4",
				"My cool FYP");
		when(academicInfoService.getAcademicInformationById(1L)).thenReturn(info);
		mvc.perform(get("/api/educational_information/1")
				.contentType(MediaType.APPLICATION_JSON)
				.content(json.write(info).getJson()))
				.andExpect(status().isOk())
				.andExpect(content().json(json.write(info).getJson()));

	}

	@Test
	public void canGetAllCandidateAcademicInfoByUserId() throws Exception {
		CandidateAcademicInfo info1 = new CandidateAcademicInfo(1L, 65L, "Masters", "AP", "KU", "no", null, "3.4",
				"My cool FYP");
		CandidateAcademicInfo info2 = new CandidateAcademicInfo(2L, 65L, "Masters", "AP", "KU", "no", null, "3.4",
				"My cool FYP");
		List<CandidateAcademicInfo> academicInfo = new ArrayList<CandidateAcademicInfo>();
		academicInfo.add(info1);
		academicInfo.add(info2);
		when(academicInfoService.getAcademicInformationByUserId(65L)).thenReturn(academicInfo);
		mvc.perform(get("/api/educational_information/user/65")
				.contentType(MediaType.APPLICATION_JSON)
				.content(jsonList.write(academicInfo).getJson()))
				.andExpect(status().isOk())
				.andExpect(content().json(jsonList.write(academicInfo).getJson()));

	}

	@Test
	public void canDeleteCandidateAcademicInfo() throws Exception {
		CandidateAcademicInfo info = new CandidateAcademicInfo(2L, 65L, "Masters", "AP", "KU", "no", null, "3.4",
				"My cool FYP");
		when(academicInfoService.getAcademicInformationById(2L)).thenReturn(info);
		mvc.perform(delete("/api/educational_information/2"))
			.andExpect(status().isNoContent());
	}

	@Test
	public void canUpdateCandidateAcademicInfo() throws Exception {
		CandidateAcademicInfo info = new CandidateAcademicInfo(2L, 65L, "Masters", "AP", "KU", "no", null, "3.4",
				"My cool FYP");
		when(academicInfoService.updateAcademicInformation(eq(2L), any(CandidateAcademicInfo.class) )).thenReturn(info);
		mvc.perform(put("/api/educational_information/2")
				.contentType(MediaType.APPLICATION_JSON)
				.content(json.write(info).getJson()))
				.andExpect(status().isOk())
				.andExpect(content().json(json.write(info).getJson()));

		// when(bookRepository.updateBook(eq(2), any())).thenReturn(false);
		mvc.perform(put("/api/educational_information/23")
				.contentType(MediaType.APPLICATION_JSON)
				.content(json.write(info).getJson()))
				.andExpect(status().isNotFound());
	}

}
