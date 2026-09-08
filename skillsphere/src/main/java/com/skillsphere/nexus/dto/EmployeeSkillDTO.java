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
public class EmployeeSkillDTO {

    private UUID id;
    private UUID employeeId;   // just the ID, not the full Employee object
    private UUID skillId;      // just the ID, not the full Skill object
    private int proficiencyScore;
}