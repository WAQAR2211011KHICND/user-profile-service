package com.xloop.resourceloop.candidateprofile.model;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter

@Entity
@Table(name = "candidate_academic_information")
public class CandidateAcademicInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Setter
    private Long user_id;
    @Setter
    private String currentDegree;
    @Setter
    private String Title;
    @Setter
    private String Institute;
    @Setter
    private String Degree_progress;
    @Setter
    @Column(columnDefinition = "date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date Graduation_date;
    @Setter
    private String CGPA; //marks
    @Setter
    private String Final_Year_Project;

    @setter
    samara

    @setter
    mufaddal;

    // @Setter
    // private String Certificates;
    // private List<MultipartFile> Certificates;
}
