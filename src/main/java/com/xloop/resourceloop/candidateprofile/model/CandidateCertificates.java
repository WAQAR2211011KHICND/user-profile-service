package com.xloop.resourceloop.candidateprofile.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@NoArgsConstructor

@Table(name="candidate-certificates")
public class CandidateCertificates {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Column(nullable = false)
    private Long userId;

    @Setter
    @Column(nullable = false)
    private String originalFileName;

    @Setter
    @Column(nullable = false)
    private String url;
    
    @Setter
    @Column(nullable = false)
    private String bucketFileName;
    
    @Setter
    @Column(nullable = false)
    private String category;


    public CandidateCertificates (long userId, String originalFileName, String url, String bucketFileName, String category){
        this.userId= userId;
        this.originalFileName = originalFileName;
        this.url= url;
        this.bucketFileName = bucketFileName;
        this.category = category;

    }
    
}
