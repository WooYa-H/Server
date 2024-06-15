package com.example.GP.domain.accountBook;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "expense")
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "expense")
    private Long id;

    private String month;

    private String day;

    private int amount;

    private String type;

    private String grouping;

}
