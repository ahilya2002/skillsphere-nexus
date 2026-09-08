package com.skillsphere.nexus.dto;

import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CompetencyFrameworkDTO {

    private UUID frameworkId;
    private String frameworkName;
    private String description;
    private UUID skillId;
    private String requiredLevel;
}