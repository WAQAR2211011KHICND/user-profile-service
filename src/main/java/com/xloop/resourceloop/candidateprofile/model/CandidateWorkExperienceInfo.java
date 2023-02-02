package com.xloop.resourceloop.candidateprofile.model;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.*;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "candidate_work_experience")
public class CandidateWorkExperienceInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    private Long userId;
    @Setter
    private String company;
    @Setter
    private String currentStatus;

    @Setter
    @Column(columnDefinition = "date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date startDate;

    @Setter
    @Column(columnDefinition = "date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date endDate;

    @Setter
    private String jobTitle;
    @Setter
    private String jobType;

}
