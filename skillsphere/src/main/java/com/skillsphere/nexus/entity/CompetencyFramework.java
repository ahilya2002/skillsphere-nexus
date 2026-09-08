package com.skillsphere.nexus.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.UUID;

@Entity
@Table(name = "competency_framework")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompetencyFramework {

    @Id
    @GeneratedValue
    private UUID frameworkId;

    private String frameworkName;

    private String description;

    @ManyToOne
    private Skill skill;

    private String requiredLevel;
}