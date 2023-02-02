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
@AllArgsConstructor
@Table(name="candidate-skills")
public class CandidateSkills {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long user_id;

    @Column(nullable = false)
    private String skill;

    @Column(nullable = false)
    private Integer proficiency;

    // public CandidateSkills(Long id, Long user_id, List<String> skills) {
    //     this.id = id;
    //     this.user_id = user_id;
    //     this.skills = skills;
    // }

    // public CandidateSkills(Long user_id, List<String> skills) {
    //     this.user_id = user_id;
    //     this.skills = skills;
    // }

    // public CandidateSkills(List<String> skills) {
    //     this.skills = skills;
    // }
    // protected CandidateSkills(){}
    
}
