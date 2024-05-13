package com.example.excel.domain;

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

    private String month;

    private String item;

    private String name;

    private String accidentNumber;

    private String securitiesNumber;

    private String targetNumber;

    private String date;

    private String investigator;

    private String contractor;

    private String bad;
}
