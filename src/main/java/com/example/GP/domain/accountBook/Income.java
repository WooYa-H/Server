package com.example.GP.domain.accountBook;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "income")
public class Income {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "income")
    private Long id;

    private String month;

    private String day;

    private int amount;

    private String type;

    private String grouping;

}
