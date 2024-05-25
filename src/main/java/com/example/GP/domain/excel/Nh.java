package com.example.GP.domain.excel;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "nh")
public class Nh {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nh_id")
    private Long id;

    private String surveyMonth;

    private String item;

    private String name;

    private String accidentNumber;

    private String securitiesNumber;

    private String targetNumber;

    private String date;

    private String investigator;

    private String contractor;

    private String recordMatch;
}
