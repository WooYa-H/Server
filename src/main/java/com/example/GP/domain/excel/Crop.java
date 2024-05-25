package com.example.GP.domain.excel;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "crop")
public class Crop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "crop_id")
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
}
