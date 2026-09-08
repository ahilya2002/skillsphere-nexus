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
public class SkillDTO {

    private UUID skillId;
    private String skillName;
    private String category;
    private String description;
    private boolean isActive;
}