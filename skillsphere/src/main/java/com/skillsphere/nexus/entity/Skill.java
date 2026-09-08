package com.skillsphere.nexus.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.UUID;

@Entity
@Table(name = "skill")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Skill {

    @Id
    @GeneratedValue
    private UUID skillId;

    private String skillName;

    private String category;
    // "Technical", "Domain", or "Soft"

    private String description;

    private Boolean isActive = true;
}