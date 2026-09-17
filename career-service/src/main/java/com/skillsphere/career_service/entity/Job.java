package com.skillsphere.career_service.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;

@Entity
@Table(name = "internal_jobs")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Job {

    @Id
    @GeneratedValue
    private UUID jobId;

    private String title;
    private String department;
    private String requiredSkills;
    private Integer minimumExperience;
    private Boolean active;
}
