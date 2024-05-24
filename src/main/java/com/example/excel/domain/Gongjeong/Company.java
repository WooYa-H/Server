package com.example.excel.domain.Gongjeong;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_id")
    private Long id;

    private String name;

    private String chief;

    private String address;

    private String businessNumber;

    private String email;

    private String phoneNumber;
}
