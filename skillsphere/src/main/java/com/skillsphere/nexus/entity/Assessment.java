package com.skillsphere.nexus.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "assessment")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Assessment {

    @Id
    @GeneratedValue
    private UUID assessmentId;

    @ManyToOne
    private Employee employee;

    @ManyToOne
    private Skill skill;

    private double score;

    private LocalDate assessmentDate;

    private boolean verified;
}