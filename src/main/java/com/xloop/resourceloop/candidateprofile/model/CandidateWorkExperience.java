package com.xloop.resourceloop.candidateprofile.model;

import java.sql.Date;

import com.xloop.resourceloop.candidateprofile.model.control_vocabulary.JobType_Enum;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "candidate_work_experience")
public class CandidateWorkExperience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column( nullable = false)
    private String jobTitle;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private JobType_Enum jobType;

    @Column( nullable = false)
    private String companyName;

    @Column( nullable = false)
    private Boolean currentWorkingHere;

    
    private Date startDate;
    private Date endDate;
    
    @Column( nullable = false)
    private Long user_id;

    public CandidateWorkExperience(String jobTitle, JobType_Enum jobType, String companyName, Boolean currentWorkingHere,
            Date startDate, Date endDate, Long user_id) {
        this.jobTitle = jobTitle;
        this.jobType = jobType;
        this.companyName = companyName;
        this.currentWorkingHere = currentWorkingHere;
        this.startDate = startDate;
        this.endDate = endDate;
        this.user_id=user_id;
    }
    public CandidateWorkExperience(){}
    
}
