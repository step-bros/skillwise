package com.stepbros.skillwise.reward;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RewardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    @Column(name = "name")
    String name;
    @Column(name = "description")
    String description;
    @Column(name = "thumbNailUrl")
    String thumbNailUrl;
    @Column(name = "cost")
    Integer cost;
}
