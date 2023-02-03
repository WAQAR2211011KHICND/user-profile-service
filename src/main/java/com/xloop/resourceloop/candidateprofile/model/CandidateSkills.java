package com.xloop.resourceloop.candidateprofile.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name="candidate-skills")
public class CandidateSkills {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private String skill;

    @Column(nullable = false)
    private Integer proficiency;

    public CandidateSkills(Long userId, String skill, Integer proficiency) {
        this.userId = userId;
        this.skill = skill;
        this.proficiency = proficiency;
    }
    

    
}
