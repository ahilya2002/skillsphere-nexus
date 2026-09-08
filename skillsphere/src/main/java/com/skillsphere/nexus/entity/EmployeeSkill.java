package com.skillsphere.nexus.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.UUID;

@Entity
@Table(name = "employee_skill")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeSkill {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    private Employee employee;

    @ManyToOne
    private Skill skill;

    private int proficiencyScore;
    // the "8/10" style rating
}